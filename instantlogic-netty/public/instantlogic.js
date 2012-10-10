YUI.add('instantlogic', function (Y) {

	// Prettier url's
	Y.HistoryHash.encode = Y.HistoryHash.decode = function(str) {return str;};
	
    var ns = Y.namespace('instantlogic');

    ns.createBaseConfiguration = function(YUI) {
    	return {
    		fragmentNamespaces: [YUI.instantlogic.fragments, YUI.instantlogic.presence],
    		createAnswer: YUI.instantlogic.answers.createAnswer
    	}
    }
    
    
    ns.Engine = function (application, caseId, travelerId, presenceNode, placeNode, configuration) {
    	this.configuration = configuration;
    	this.application = application;
    	this.caseId = caseId;
    	this.presenceNode = presenceNode;
        this.placeNode = placeNode;
        this.travelerId = travelerId;
        if (!configuration.fragmentNamespaces || configuration.fragmentNamespaces.length == 0) Y.error('No fragment namespaces');
        Y.each(configuration.fragmentNamespaces, function (fns) {
            if (!fns) Y.error('Undefined namespace');
        });
        this.fragmentNamespaces = configuration.fragmentNamespaces;
        if (!configuration.createAnswer) {
        	Y.error('undefined createAnswer');
        }
        this.createAnswerFunction = configuration.createAnswer;
        this.state = 'not started';
        this.outstandingRequestCount = 0;
        this.outstandingRequests = {};
        this.messagesQueue = [];
        this.placeFragmentHolder = null;
        this.presenceFragmentHolder = null;

        this.oneMomentPleasePanel = new Y.Panel({
            bodyContent: 'ONE MOMENT PLEASE',
            visible: false,
            centered: true,
            zIndex: 10,
            disabled: true,
            modal: true,
            render: true
        });
        this.errorPanel = new Y.Panel({
            bodyContent: 'ERROR',
            visible: false,
            centered: true,
            zIndex: 10,
            disabled: true,
            modal: true,
            render: true
        });
    };

    ns.Engine.prototype = {
        // API
        start: function () {
        	this.history = new Y.HistoryHash();
        	this.history.on('locationChange', this.onLocationChange, this);
            this.location = this.history.get('location');
            if (!location) Y.error('no location given');
            this.presenceNode.setContent('One moment...');
            this.setState('connecting');
            this.sendEnter();
            var me = this;
            window.onbeforeunload = function() {
            	me.stop();
            }
        },
        
        stop: function() {
        	this.setState('stopped');
        	for (var id in this.outstandingRequests) {
        		this.outstandingRequests[id].abort();
        		this.outstandingRequestCount--;
        	}
        	// TODO: send leave message immediately
        },
        
        onLocationChange: function(e) {
        	if (e.src !== Y.HistoryBase.SRC_ADD) {
        		this.location = e.newVal;
        		this.sendEnter();
        	}
        },

        // Private functions
        setState: function (state) {
            if (this.state == state) return;
            this.state = state;
            if (state == 'connected' || state == 'error') {
                this.oneMomentPleasePanel.hide();
            };
            if (state == 'connecting' || state == 'disconnected') {
                this.oneMomentPleasePanel.show();
                this.placeNode.setContent('');
                if (this.placeFragmentHolder) {
                    this.placeFragmentHolder.destroy();
                    this.placeFragmentHolder = null;
                }
                this.presenceNode.setContent('');
                if (this.presenceFragmentHolder) {
                    this.presenceFragmentHolder.destroy();
                    this.presenceFragmentHolder = null;
                }
            }
            if (state == 'error') {
            	this.errorPanel.show();
            } else {
            	this.errorPanel.hide();
            }
        },

        processUpdates: function (updates) {
            var messages = Y.JSON.parse(updates);
            for (var i = 0; i < messages.length; i++) {
                var message = messages[i];
                switch (message.name) {
                    case 'place':
                    	if (this.location!=message.location) {
	                    	this.location = message.location;
	                    	this.history.addValue('location', this.location);
                    	}
                        this.updatePlace(message.rootFragment);
                        break;
                    case 'presence':
                    	this.updatePresence(message.rootFragment);
                    	break;
                    case 'filesUpdated':
                        document.location.reload();
                        break;
                    case 'exception':
                    	this.setState('error');
                        break;
                    default:
                        Y.error('Unknown message ' + message.name);
                }
            }
        },

        updatePresence: function (model) {
            var diff = new ns.Diff();
            if (!this.presenceFragmentHolder) {
                this.presenceFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, this);
                this.presenceNode.appendChild(this.presenceFragmentHolder.node);
                diff.nodeAdded(this.presenceFragmentHolder.node);
                this.presenceFragmentHolder.init(model);
            } else {
                this.presenceFragmentHolder.update(model, diff);
            }
            diff.applyNow();
        },

        updatePlace: function (model) {
            var diff = new ns.Diff();
            if (!this.placeFragmentHolder || this.placeFragmentHolder.id != model.id) {
                if (this.placeFragmentHolder) {
                    diff.nodeToRemove(this.placeFragmentHolder.node);
                    this.placeFragmentHolder.destroy();
                }
                this.placeFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, this);
                this.placeNode.appendChild(this.placeFragmentHolder.node);
                diff.nodeAdded(this.placeFragmentHolder.node);
                this.placeFragmentHolder.init(model);
            } else {
                this.placeFragmentHolder.update(model, diff);
            }
            diff.applyNow();
        },

        createFragment: function (name, parentNode, engine) {
            for (var i = 0; i < this.fragmentNamespaces.length; i++) {
                var fns = this.fragmentNamespaces[i];
                if (fns[name]) {
                    return new fns[name](parentNode, engine || this);
                }
            }
            return new ns.MessageFragment(parentNode, engine || this, 'No fragmentnamespace provides a fragment called ' + name, 'error');
        },
        
        createAnswer: function(model) {
        	return this.createAnswerFunction(model);
        },
        
        sendEnter: function() {
        	this.enqueueMessage({message:'enter', location: this.location});        	
        },
        
        sendSubmit: function(id) {
        	this.enqueueMessage({message:'submit', id:id});
        },
        
        sendChange: function(id, value) {
        	this.enqueueMessage({message:'change', id:id, value:value});
        },
        
        enqueueMessage: function(message) {
        	this.messagesQueue.push(message);
        	this.triggerMessagesTransport();
        },
        
        triggerMessagesTransport: function() {
        	if (this.state=='connected' || this.state=='connecting') {
	        	if (this.outstandingRequestCount<2) { // No more than 2 requests should be underway
	        		if (this.messagesQueue.length>0 || this.outstandingRequestCount==0) {
	        			this.transportMessages(); // Send a new (maybe empty) request
	        		}
	        	}
        	}
        },

        transportMessages: function () {
        	var messages = this.messagesQueue;
        	this.messagesQueue = [];
        	var data = (messages && messages.length>0) ? JSON.stringify(messages) : null;
        	var transaction = Y.io('/place?application='+this.application+'&case='+this.caseId+'&travelerId=' + travelerId, {
            	data: data,
                method: 'POST',
                on: {
                    success: function (transactionid, response) {
                    	this.outstandingRequestCount--;
                    	if (!this.outstandingRequests[transactionid]) Y.error();
                    	delete this.outstandingRequests[transactionid];
                        this.setState('connected');
                        this.processUpdates(response.responseText);
                        this.triggerMessagesTransport();
                    },
                    failure: function (transactionid, response) {
                    	this.outstandingRequestCount--;
                    	delete this.outstandingRequests[transactionid];
                        if (!response.status || response.status > 600) {
                            this.setState('disconnected');
                            var me = this;
                        	setTimeout(function () {
                        		me.setState('connecting');
                        		me.sendEnter(); 
                        	}, 300);
                        } else {
                        	this.setState('error');
                        }
                    }
                },
                context: this
            });
        	this.outstandingRequests[transaction.id]=transaction;
        	this.outstandingRequestCount++;
        }
    };

    // Diff
    ns.Diff = function () {
        this.nodesAdded = [];
        this.nodesToRemove = [];
        this.nodesUpdated = [];
    };

    ns.Diff.prototype = {
        nodeAdded: function (node) {
            this.nodesAdded.push(node);
        },
        nodeToRemove: function (node) {
            this.nodesToRemove.push(node);
        },
        nodeUpdated: function (node) {
            this.nodesUpdated.push(node);
        },
        applyNow: function () {
            for (var i = 0; i < this.nodesToRemove.length; i++) {
                this.nodesToRemove[i].remove(true);
            }
        },
        toString: function () {
            return 'Diff';
        }
    };

    //FragmentHolder
    ns.FragmentHolder = function (id, engine) {
        this.id = id;
        this.engine = engine;
        this.node = Y.html.span({ 'data-fragment-id': id, className: 'fragment' });
        this.fragment = null;
    };

    ns.FragmentHolder.prototype = {
        init: function (model) {
            this.fragmentType = model.type;
            if (this.engine.configuration.debug) this.addDebugTool();
            this.fragment = this.engine.createFragment(this.fragmentType, this.node);
            this.fragment.init(model);
            if (this.fragment.markup) {
            	this.node.appendChild(this.fragment.markup);
            }
        },

        update: function (newModel, diff) {
            if (this.fragmentType != newModel.type || !this.fragment.canUpdateFrom(newModel)) {
                this.recreateFragment(newModel, diff);
            } else {
                this.fragment.update(newModel, diff);
            }
        },

        recreateFragment: function (newModel, diff) {
            this.fragment.destroy();
            var oldNode = this.node;
            this.node = Y.html.span({ 'data-fragment-id': newModel.id, className: 'fragment' });
            oldNode.ancestor().insertBefore(this.node, oldNode); // oldNode can be removed using animation
            diff.nodeToRemove(oldNode);
            diff.nodeAdded(this.node);
            this.fragment = this.engine.createFragment(newModel.type, this.node, this.engine);
            this.fragment.init(this.node, newModel);
        },

        destroy: function () {
            this.fragment.destroy();
        },
        
        addDebugTool: function() {
        	var h = Y.html;
        	var button;
        	var openMenu;
        	function closeMenu() {
        		if (openMenu) {
        			debugTool.removeClass('openMenu');
        			openMenu.remove(true);
        			openMenu = null;
        		}
        	}
        	var me = this;
        	var debugTool = 
        		h.div({className: 'fragment-debug'},
        			h.div({className: 'fragment-debug-info-outer'}, 
        				h.div({className: 'fragment-debug-info'}, this.fragmentType)
        			),
        			button = h.div({className: 'fragment-debug-button'})
        		);
        	this.node.appendChild(debugTool);
        	button.on('hover', function() {debugTool.addClass('hover')}, function() {closeMenu();debugTool.removeClass('hover')});
        	button.on('click', function(e) {
        		if (openMenu) {
        			closeMenu();
            		if (e.target!=button) {
            			debugTool.removeClass('hover');
            		}
        			return;
        		}
        		var logLink, locateLink, editLink, insertAboveLink, insertBelowLink;
        		openMenu =
        			h.div({className: 'fragment-debug-menu'},
        				h.ul(
        					h.li(logLink = h.a({href:'#'}, 'Log fragment data')),
        					h.li(locateLink = h.a({href:'#', target:'designer'}, 'Locate')),
        					h.li(editLink = h.a({href:'#', target:'designer'}, 'Edit')),
        					h.li(insertAboveLink = h.a({href:'#', target:'designer'}, 'Insert above')),
        					// TODO Insert inside(start of) each fragmentList
        					h.li(insertBelowLink = h.a({href:'#', target:'designer'}, 'Insert below'))
        				)
        			);
    			button.appendChild(openMenu)
    			logLink.on('click', function(e){
    				window.console.log('Fragment:', me.fragment.model);
    				window.console.log(JSON.stringify(me.fragment.model, null, ' '));
    				e.preventDefault();
    			});
        	});
        },

        toString: function () {
            return 'FragmentHolder#' + this.id;
        }
    };

    // FragmentList
    ns.FragmentList = function (parentNode, engine) {
        this.engine = engine;
        this.parentNode = parentNode;
    };

    ns.FragmentList.prototype = {
        init: function (models) {
            if (!models) models = [];
            this.models = models;
            this.fragmentHolders = [];
            for (var i = 0; i < models.length; i++) {
                var fragmentHolder = new ns.FragmentHolder(models[i].id, this.engine);
                this.parentNode.appendChild(fragmentHolder.node);
                fragmentHolder.init(models[i]);
                this.fragmentHolders.push(fragmentHolder);
            }
        },

        update: function (newModels, diff) {

            function indexOfModelWithId(models, id, start) {
                for (var i = start; i < models.length; i++) {
                    if (models[i].id == id) {
                        return i;
                    }
                }
                return -1;
            };
            
            if (!newModels) newModels = [];
            if (this.models.length != this.fragmentHolders.length) {
                throw new Error('model/fragments mismatch');
            }
            var oldModels = this.models;
            this.models = newModels;
            var oldIndex = 0;
            var newIndex = 0;
            var i;
            while (newIndex < newModels.length) {
                var oldModel = (oldIndex < oldModels.length) ? oldModels[oldIndex] : {};
                var newModel = newModels[newIndex];
                if (oldModel.id != newModel.id) {
                    var findOldIndex = indexOfModelWithId(oldModels, newModel.id, oldIndex + 1);
                    if (findOldIndex >= 0) {
                        // remove child fragments
                        for (i = newIndex; i < newIndex + findOldIndex - oldIndex; i++) {
                            diff.nodeToRemove(this.fragmentHolders[i].node);
                            this.fragmentHolders[i].destroy();
                        }
                        this.fragmentHolders.splice(newIndex, findOldIndex - oldIndex);
                        oldIndex = findOldIndex + 1;
                        this.fragmentHolders[newIndex].update(newModel, diff);
                    } else {
                        // New fragmentHolder
                        var fragmentHolder = new ns.FragmentHolder(newModel.id, this.engine);
                        this.fragmentHolders.splice(newIndex, 0, fragmentHolder);
                        if (this.fragmentHolders.length > newIndex + 1) {
                            this.parentNode.insertBefore(fragmentHolder.node, this.fragmentHolders[newIndex + 1].node);
                        } else {
                            this.parentNode.appendChild(fragmentHolder.node);
                        }
                        fragmentHolder.init(newModel);
                        diff.nodeAdded(fragmentHolder.node);
                    }
                } else {
                    this.fragmentHolders[newIndex].update(newModel, diff);
                    oldIndex++;
                }
                newIndex++;
            }
            if (this.fragmentHolders.length > newIndex) {
                // Remove child fragments
                for (i = newIndex; i < this.fragmentHolders.length; i++) {
                    diff.nodeToRemove(this.fragmentHolders[i].node);
                    this.fragmentHolders[i].destroy();
                }
                this.fragmentHolders.length = newIndex;
            }
        },

        destroy: function () {
            for (var i = 0; i < this.fragmentHolders.length; i++) {
                this.fragmentHolders[i].destroy();
            }
        },

        toString: function () {
            return 'FragmentList';
        }
    };

    // Fragment
    ns.Fragment = function (parentNode, engine) {
    	if (!parentNode) Y.error();
    	if (!engine) Y.error();
        this.engine = engine;
        this.oldModel = {};
        this.parentNode = parentNode;
        this.model = null;
    };

    ns.Fragment.prototype = {
        init: function (model) {
            this.model = model;
        },

        canUpdateFrom: function (newModel) {
            return true;
        },

        update: function (newModel, diff) {
            this.oldModel = this.model;
            this.model = newModel;
        },

        // Remove listeners, but leave the dom-tree intact
        destroy: function () {
        }
    };
    
    ns.MessageFragment = function (parentNode, engine, message, messageclassName) {
        ns.MessageFragment.superclass.constructor.apply(this, arguments);
        this.message = message;
        this.messageclassName = messageclassName;
    };

    Y.extend(ns.MessageFragment, Y.instantlogic.Fragment, {
        init: function (model) {
        	ns.MessageFragment.superclass.init.call(this, model);
        	var markup = Y.html.div({className:'message '+this.messageclassName}, 
        		Y.html.div({className:'icon'}),
        		Y.html.p(this.message)
        	);
        	this.parentNode.appendChild(markup);
        },
        
        canUpdateFrom: function (newModel) {
        	return false;
        }
    });
    
    /*
     * Create a subclass of Fragment or one of its subclasses, the options parameter can contain the following:
     * - baseClass: optional, choose another baseClass than Y.instantlogic.Fragment
     * - overrides: optional, object containing methods to be overridden in/added to the baseClass 
     * - createMarkup: function for creating the markup, this markup will be appended to this.parentNode
     * - texts: function(model), optional, must return an array of tuples with [0]: the div from the markup
     * and [1]: the text from the model to render there
     * - fragmentLists: function(model), optional, must return an array of tuples with [0]: the div from the markup 
     * and [1]: the list of elements in the model to render there
     * - postInit: function(model), optional, runs after the init phase has been completed
     * - postUpdate: function(newModel, diff), optional, runs after the update phase has been completed
     * */
    ns.createFragment = function(options) {
    	var constructor = function(parentNode, engine) {
    		constructor.superclass.constructor.apply(this, arguments);
    	}
    	Y.extend(constructor, options.baseClass || Y.instantlogic.Fragment, options.overrides);
    	
    	constructor.prototype.init = function(model) {
    		constructor.superclass.init.call(this, model);
    		if (options.createMarkup) {
	    		this.markup = options.createMarkup.apply(this);
	    		if (model.styleNames) {
	    			for (var i=0;i<model.styleNames.length;i++) {
	    				this.markup.addClass(model.styleNames[i]);
	    			}
	    		}
    		}
    		if (options.fragmentLists) {
    			this.fragmentLists = [];
    			var results = options.fragmentLists.call(this, model);
    			for (var i=0;i<results.length;i++) {
    				var list = new ns.FragmentList(results[i][0], this.engine);
    				list.init(results[i][1]);
    				this.fragmentLists.push(list);
    			}
    		}
    		if (options.texts) {
    			var results = options.texts.call(this, model);
    			for (var i=0;i<results.length;i++) {
    				results[i][0].set('text', results[i][1] || '');
    			}
    		}
    		if (options.postInit) {
    			options.postInit.call(this, model);
    		}
    	};
    	
    	constructor.prototype.update = function(newModel, diff) {
    		constructor.superclass.update.call(this, newModel, diff);
    		if (this.fragmentLists) {
    			var results = options.fragmentLists.call(this, newModel);
    			for (var i=0;i<results.length;i++) {
    				this.fragmentLists[i].update(results[i][1], diff);
    			}
    		}
    		if (options.texts) {
    			var newResults = options.texts.call(this, newModel);
    			var oldResults = options.texts.call(this, this.oldModel);
    			for (var i=0;i<newResults.length;i++) {
    				if (newResults[i][1]!=oldResults[i][1]) {
    					newResults[i][0].set('text', newResults[i][1] || '');
    				}
    			}
    		}
    		if (options.postUpdate) {
    			options.postUpdate.call(this, newModel, diff);
    		}
    	}

    	constructor.prototype.destroy = function() {
    		constructor.superclass.destroy.call(this);
    		if (this.fragmentLists) {
    			for (var i=0;i<this.fragmentLists;i++) {
    				this.fragmentLists[i].destroy();
    			}
    		}
    	};
    	
    	return constructor;
    };
    
}, '0.7.0', { requires: ['io-base', 'node', 'oop', 'panel', 'json', 'event', 'html', 'history'] });