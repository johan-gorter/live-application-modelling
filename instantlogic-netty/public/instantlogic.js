YUI.add('instantlogic', function(Y) {
	
    Y.instantlogic = function(travelerId, container, widgetNamespaces) {
    	this.container = container;
    	this.travelerId = travelerId;
    	this.widgetNamespaces = widgetNamespaces || [Y.instantlogic.widget];
    	this.state = 'not started';
    	
    	this.overlay = new Y.Panel({
    		bodyContent: 'ONE MOMENT PLEASE',
    		visible: false,
    		centered: true,
    		zIndex:10,
    		disabled:true,
    		modal:true
    	});
    	this.overlay.render();
    };
    
    Y.instantlogic.prototype = {
    	
    	// API
    	start: function() {
    		this.container.setContent('One moment...');
    		this.setState('connecting');
    		this.startRequest();
    	},
    	
    	// Private functions
    	setState: function(state) {
    		if (this.state==state) return;
    		this.state=state;
    		if (state=='connected') {
    			this.overlay.hide();
    		};
    		if (state=='connecting' || state=='disconnected') {
    			this.overlay.show();
    			this.container.setContent('');
    		}
    	},
    	
    	processUpdates: function(updates) {
    		var messages = Y.JSON.parse(updates);
    		for (var i=0;i<messages.length;i++) {
    			var message = messages[i];
    			switch (message.message) {
					case 'place':
						this.updatePlace(message.rootFragment);
						break;
					case 'filesUpdated':
						document.location.reload();
						break;
    				default:
    					Y.error('Unknown message '+message.message);
    			}
    		}
    	},
    	
    	updatePlace: function(rootFragment) {
			var widget = this.createWidget(rootFragment);
			widget.render(this.container);
    	},
    	
    	createWidget: function(message) {
    		if (message.widget) {
    			for (var i=0;i<this.widgetNamespaces.length;i++) {
    				var ns = this.widgetNamespaces[i];
    				if (ns[message.widget]) {
    					return new ns[message.widget](message);
    				}
    			}
    			Y.error('No widgetnamespace provides a widget called '+message.widget);
    		}
    		return null;
    	},
    	
    	startRequest: function() {
			Y.io('/place?travelerId='+travelerId, {
				method: 'POST',
				on: {
					success: function(transactionid, response) {
						this.setState('connected');
						this.processUpdates(response.responseText);
						this.startRequest();
					},
					failure: function() {
						this.setState('disconnected');
						var me = this;
						setTimeout(function(){me.startRequest();}, 300);
					}
				},
				context: this
			});
    	}
    };

    // Diff
    Y.instantlogic.Diff = function() {
    	this.nodesAdded = [];
    	this.nodesToRemove = [];
    	this.nodesUpdated = [];
    }
    
    Y.instantlogic.Diff.prototype = {
    	addNodeAdded: function(node) {
    		this.nodesAdded.push(node);
    	},
    	addNodeToRemove: function(node) {
    		this.nodesToRemove.push(node);
    	},
    	addNodeUpdated: function(node) {
    		this.nodesUpdated.push(node);
    	},
    	applyNow: function() {
    		for (var i=0;i<this.nodesToRemove.length;i++) {
    			this.nodesToRemove[i].remove(true);
    		}
    	},
    	toString: function() {
    		return 'Diff';
    	}
    }
    
    //Fragment
    Y.instantlogic.Fragment = function(id) {
    	this.node = Y.html.span({id: id, cssClass: 'fragment'});
    	this.childFragments = null;
    	this.widget = null;
    };
    
    Y.instantlogic.Fragment.prototype = {
    		
    	init: function(model, instantlogic, diff) {
        	this.model = model;
        	if (model.widget) {
        		this.widget = instantlogic.createWidget(model);
    			this.widget.render(this.node);
        	} else if (model.children) {
        		this.childFragments = new Y.instantlogic.FragmentList(this.node, model.children, instantlogic, diff);
        	}	
    	},
    	
    	update: function(newModel, instantlogic, diff) {
    		var oldModel = this.model;
    		this.model = newModel;
        	function recreateWidget(newModel, instantlogic) {
        		if (this.widget) {
        			this.widget.destroy();
        			this.widget = null;
        			this.node.setContent('');
        		}
    			this.widget = instantlogic.createWidget(newModel);
    			this.widget.render(this.node);
        	}
    		if (newModel.widget) {
    			if (this.childFragments) {
    				this.childFragments.destroy();
    				this.childFragments = null;
    				this.node.setContent('');
    			}
				if (newModel.widget != oldModel.widget) {
					recreateWidget(newModel, instantlogic);
				} else {
					try {
						this.widget.setAttrs(newModel);
					} catch (err) {
						recreateWidget(newModel, instantlogic);
					}
				}
    		} else if (newModel.children) {
    			if (this.widget) {
        			this.widget.destroy();
        			this.node.setContent('');
        			this.widget = null;
    			}
    			if (this.childFragments) {
    				this.childFragments.update(newModel.children, instantlogic, diff)
    			} else {
    				this.childFragments = new Y.instantlogic.FragmentList(this.node, newModel.children, instantlogic, diff);
    			}
    		}
    	},
    	
    	destroy: function() {
    		if (this.widget) {
    			this.widget.destroy();
    		} else if (this.childFragments) {
    			this.childFragments.destroy();
    		}
    	},
    	
    	toString: function() {
    		return 'Fragment '+this.node.getAttribute('id');
    	}
    }
    
    // FragmentList
    Y.instantlogic.FragmentList = function(parentNode, models, instantlogic, diff) {
    	this.parentNode = parentNode;
    	this.models = models;
    	this.fragments = [];
    	for (var i=0;i<models.length;i++) {
    		var fragment = new Y.instantlogic.Fragment(models[i].id);
    		parentNode.appendChild(fragment.node);
    		fragment.init(models[i], instantlogic, diff);
    		this.fragments.push(fragment);
    	}
    }
    
    Y.instantlogic.FragmentList.prototype = {
    	
    	update: function(newModels, instantlogic, diff) {
    		function indexOfModelWithId(models, id, start) {
    	        for (var i = start; i < models.length; i++) {
    	            if (models[i].id == id) { return i; }
    	        }
    	        return -1;
    	    };    		
            if (this.models.length != this.fragments.length) { throw new Error('model/fragments mismatch'); }
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
                        	diff.addNodeToRemove(this.fragments[i].node);
                            this.fragments[i].destroy();
                        }
                        this.fragments.splice(newIndex, findOldIndex - oldIndex);
                        oldIndex = findOldIndex + 1;
                        this.fragments[newIndex].update(newModel, instantlogic, diff);
                    } else {
                        // New fragment
                        var fragment = new Y.instantlogic.Fragment(newModel.id, instantlogic);
                        this.fragments.splice(newIndex, 0, fragment);
                        if (this.fragments.length>newIndex+1) {
                        	this.parentNode.insertBefore(fragment.node, this.fragments[newIndex+1].node);
                        } else {
                        	this.parentNode.appendChild(fragment.node);
                        }
                        diff.addNodeAdded(fragment.node);
                    }
                } else {
                    this.fragments[newIndex].update(newModel, instantlogic, diff);
                    oldIndex++;
                }
                newIndex++;
            }
            if (this.fragments.length > newIndex) {
                // Remove child fragments
                for (i = newIndex; i < this.fragments.length; i++) {
                	diff.addNodeToRemove(this.fragments[i].node);
                    this.fragments[i].destroy();
                }
                this.fragments.length = newIndex;
            }
    	},
    	
    	destroy: function() {
        	for (var i=0;i<this.fragments.length;i++) {
        		this.fragments[i].destroy();
        	}
    	},

    	toString: function() {
    		return 'FragmentList';
    	}
    	
    } 

}, '3.4.1', { requires: ['io-base','node','oop','panel','json','slider','html'] });