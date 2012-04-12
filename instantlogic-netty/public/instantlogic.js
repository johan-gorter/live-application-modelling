YUI.add('instantlogic', function(Y) {
	
    Y.instantlogic = function(travelerId, container, widgetNamespaces) {
    	this._container = container;
    	this._travelerId = travelerId;
    	this._widgetNamespaces = widgetNamespaces || [Y.instantlogic.widget];
    	this._state = 'not started';
    	
    	this._overlay = new Y.Panel({
    		bodyContent: 'ONE MOMENT PLEASE',
    		visible: false,
    		centered: true,
    		zIndex:10,
    		disabled:true,
    		modal:true
    	});
    	this._overlay.render();
    };
    
    Y.instantlogic.prototype = {
    	
    	// API
    	start: function() {
    		this._container.setContent('One moment...');
    		this._setState('connecting');
    		this._startRequest();
    	},
    	
    	// Private functions
    	_setState: function(state) {
    		if (this._state==state) return;
    		this._state=state;
    		if (state=='connected') {
    			this._overlay.hide();
    		};
    		if (state=='connecting' || state=='disconnected') {
    			this._overlay.show();
    			this._container.setContent('');
    		}
    	},
    	
    	_processUpdates: function(updates) {
    		var messages = Y.JSON.parse(updates);
    		for (var i=0;i<messages.length;i++) {
    			var message = messages[i];
    			switch (message.message) {
					case 'place':
						this._updatePlace(message.rootFragment);
						break;
					case 'filesUpdated':
						document.location.reload();
						break;
    				default:
    					Y.error('Unknown message '+message.message);
    			}
    		}
    	},
    	
    	_updatePlace: function(rootFragment) {
			var widget = this._createWidget(rootFragment);
			widget.render(this._container);
    	},
    	
    	_createWidget: function(message) {
    		if (message.widget) {
    			for (var i=0;i<this._widgetNamespaces.length;i++) {
    				var ns = this._widgetNamespaces[i];
    				if (ns[message.widget]) {
    					return new ns[message.widget](message);
    				}
    			}
    			Y.error('No widgetnamespace provides a widget called '+message.widget);
    		}
    		return null;
    	},
    	
    	_startRequest: function() {
			Y.io('/place?travelerId='+travelerId, {
				method: 'POST',
				on: {
					success: function(transactionid, response) {
						this._setState('connected');
						this._processUpdates(response.responseText);
						this._startRequest();
					},
					failure: function() {
						this._setState('disconnected');
						var me = this;
						setTimeout(function(){me._startRequest();}, 300);
					}
				},
				context: this
			});
    	}
    };
    		
}, '3.4.1', { requires: ['io-base','node','oop','panel','json','slider'] });