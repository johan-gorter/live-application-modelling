YUI.add('instantlogic', function (Y) {

	// Prettier url's
	Y.HistoryHash.encode = Y.HistoryHash.decode = function(str) {return str;};
	
    var ns = Y.namespace('instantlogic');

    ns.Engine = function (application, caseId, travelerId, presenceNode, placeNode, fragmentNamespaces) {
    	this.application = application;
    	this.caseId = caseId;
    	this.presenceNode = presenceNode;
        this.placeNode = placeNode;
        this.travelerId = travelerId;
        if (!fragmentNamespaces || fragmentNamespaces.length == 0) Y.error('No fragment namespaces');
        Y.each(fragmentNamespaces, function (fns) {
            if (!fns) Y.error('Undefined namespace');
        });
        this.fragmentNamespaces = fragmentNamespaces;
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
                switch (message.message) {
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
                    default:
                        Y.error('Unknown message ' + message.message);
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
        
        sendEnter: function() {
        	this.enqueueMessage({message:'enter', location: this.location});        	
        },
        
        sendEvent: function(id) {
        	this.enqueueMessage({message:'event', id:id});
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
            this.fragment = this.engine.createFragment(this.fragmentType, this.node);
            this.fragment.init(model);
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
            this.node = Y.html.span({ 'data-fragment-id': id, className: 'fragment' });
            oldNode.ancestor().insertBefore(this.node, oldNode); // oldNode can be removed using animation
            diff.nodeToRemove(oldNode);
            diff.nodeAdded(this.node);
            this.fragment = this.engine.createFragment(newModel);
            this.fragment.init(this.node, newModel);
        },

        destroy: function () {
            this.fragment.destroy();
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
            }

            ;
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
                    this.fragments[i].destroy();
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
        this.previousModel = {};
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
            this.previousModel = this.model;
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
    
}, '0.7.0', { requires: ['io-base', 'node', 'oop', 'panel', 'json', 'slider', 'html', 'history'] });