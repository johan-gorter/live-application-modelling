YUI.add('instantlogic', function (Y) {

    var ns = Y.namespace('instantlogic');

    // Engine is a FragmentFactory
    ns.Engine = function (application, caseId, travelerId, containerNode, fragmentNamespaces) {
    	this.application = application;
    	this.caseId = caseId;
        this.containerNode = containerNode;
        this.travelerId = travelerId;
        if (!fragmentNamespaces || fragmentNamespaces.length == 0) Y.error('No fragment namespaces');
        Y.each(fragmentNamespaces, function (fns) {
            if (!fns) Y.error('Undefined namespace');
        });
        this.fragmentNamespaces = fragmentNamespaces;
        this.state = 'not started';
        this.outstandingRequests = 0;
        this.messagesQueue = [];
        this.rootFragmentHolder = null;

        this.oneMomentPlease = new Y.Panel({
            bodyContent: 'ONE MOMENT PLEASE',
            visible: false,
            centered: true,
            zIndex: 10,
            disabled: true,
            modal: true
        });
        this.oneMomentPlease.render();
    };

    ns.Engine.prototype = {
        // API
        start: function () {
        	this.history = new Y.HistoryHash();
            this.location = this.history.get('location');
            if (!location) Y.error('no location given');
            this.containerNode.setContent('One moment...');
            this.setState('connecting');
            this.sendEnter();
        },

        // Private functions
        setState: function (state) {
            if (this.state == state) return;
            this.state = state;
            if (state == 'connected') {
                this.oneMomentPlease.hide();
            };
            if (state == 'connecting' || state == 'disconnected') {
                this.oneMomentPlease.show();
                this.containerNode.setContent('');
                if (this.rootFragment) {
                    this.rootFragment.destroy();
                    this.rootFragment = null;
                }
            }
        },

        processUpdates: function (updates) {
            var messages = Y.JSON.parse(updates);
            for (var i = 0; i < messages.length; i++) {
                var message = messages[i];
                switch (message.message) {
                    case 'place':
                        this.updatePlace(message.rootFragment);
                        break;
                    case 'filesUpdated':
                        document.location.reload();
                        break;
                    default:
                        Y.error('Unknown message ' + message.message);
                }
            }
        },

        updatePlace: function (model) {
            var diff = new ns.Diff();
            if (!this.rootFragmentHolder || this.rootFragmentHolder.id != model.id) {
                if (this.rootFragmentHolder) {
                    diff.nodeToRemove(this.rootFragmentHolder.node);
                    this.rootFragmentHolder.destroy();
                }
                this.rootFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, this);
                this.containerNode.appendChild(this.rootFragmentHolder.node);
                diff.nodeAdded(this.rootFragmentHolder.node);
                this.rootFragmentHolder.init(model);
            } else {
                this.rootFragmentHolder.update(model, diff);
            }
            diff.applyNow();
        },

        createFragment: function (name, parentNode, fragmentFactory) {
            for (var i = 0; i < this.fragmentNamespaces.length; i++) {
                var fns = this.fragmentNamespaces[i];
                if (fns[name]) {
                    return new fns[name](parentNode, fragmentFactory || this);
                }
            }
            return new ns.MessageFragment(parentNode, fragmentFactory || this, 'No fragmentnamespace provides a fragment called ' + name, 'error');
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
        	if (this.outstandingRequests<2 && this.messagesQueue.length>0) {
        		this.transportMessages();
        	}
        },

        transportMessages: function () {
        	var messages = this.messagesQueue;
        	this.messagesQueue = [];
        	var data = (messages && messages.length>0) ? JSON.stringify(messages) : null;
        	this.outstandingRequests++;
            Y.io('/place?application='+this.application+'&case='+this.caseId+'&travelerId=' + travelerId, {
            	data: data,
                method: 'POST',
                on: {
                    success: function (transactionid, response) {
                    	this.outstandingRequests--;
                        this.setState('connected');
                        this.processUpdates(response.responseText);
                        this.triggerMessagesTransport();
                    },
                    failure: function () {
                    	this.outstandingRequests--;
                        this.setState('disconnected');
                        var me = this;
                        setTimeout(function () { me.sendEnter(); }, 300);
                    }
                },
                context: this
            });
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
    ns.FragmentHolder = function (id, fragmentFactory) {
        this.id = id;
        this.fragmentFactory = fragmentFactory;
        this.node = Y.html.span({ 'data-fragment-id': id, cssClass: 'fragment' });
        this.fragment = null;
    };

    ns.FragmentHolder.prototype = {
        init: function (model) {
            this.fragmentType = model.type;
            this.fragment = this.fragmentFactory.createFragment(this.fragmentType, this.node);
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
            this.node = Y.html.span({ 'data-fragment-id': id, cssClass: 'fragment' });
            oldNode.ancestor().insertBefore(this.node, oldNode); // oldNode can be removed using animation
            diff.nodeToRemove(oldNode);
            diff.nodeAdded(this.node);
            this.fragment = this.fragmentFactory.createFragment(newModel);
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
    ns.FragmentList = function (parentNode, fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
        this.parentNode = parentNode;
    };

    ns.FragmentList.prototype = {
        init: function (models) {
            if (!models) models = [];
            this.models = models;
            this.fragmentHolders = [];
            for (var i = 0; i < models.length; i++) {
                var fragmentHolder = new ns.FragmentHolder(models[i].id, this.fragmentFactory);
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
                        var fragmentHolder = new FragmentHolder(newModel.id, this.fragmentFactory);
                        this.fragmentHolders.splice(newIndex, 0, fragmentHolder);
                        if (this.fragmentHolders.length > newIndex + 1) {
                            this.parentNode.insertBefore(fragmentHolder.node, this.fragmentHolders[newIndex + 1].node);
                        } else {
                            this.parentNode.appendChild(fragmentHolder.node);
                        }
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
    ns.Fragment = function (parentNode, fragmentFactory) {
    	if (!parentNode) Y.error();
    	if (!fragmentFactory) Y.error();
        this.fragmentFactory = fragmentFactory;
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
    
    ns.MessageFragment = function (parentNode, fragmentFactory, message, messageCssClass) {
        ns.MessageFragment.superclass.constructor.apply(this, arguments);
        this.message = message;
        this.messageCssClass = messageCssClass;
    };

    Y.extend(ns.MessageFragment, Y.instantlogic.Fragment, {
        init: function (model) {
        	ns.MessageFragment.superclass.init.call(this, model);
        	var markup = Y.html.div({cssClass:'message '+this.messageCssClass}, 
        		Y.html.div({cssClass:'icon'}),
        		Y.html.p(this.message)
        	);
        	this.parentNode.appendChild(markup);
        },
        
        canUpdateFrom: function (newModel) {
        	return false;
        }
    });
    
}, '3.4.1', { requires: ['io-base', 'node', 'oop', 'panel', 'json', 'slider', 'html', 'history'] });