YUI.add('instantlogic-presence', function (Y) {

    var ns = Y.namespace('instantlogic.presence');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // Presence
    ns.Presence = function (parentNode, engine) {
        ns.Presence.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Presence, Y.instantlogic.Fragment, {
    	init: function(model) {
            ns.Presence.superclass.init.call(this, model);
            var markup = html.div({ className: 'navbar navbar-inverse navbar-fixed-top' },
            	html.div({className: 'navbar-inner'},
            		html.div({className:'container'},
            			html.div({className:'nav-collapse collapse'},
		            		html.p({className: 'navbar-text pull-left'},
		            			this.applicationNameSpan = html.span({className: 'application-name'}, model.applicationName || ''),
			            		html.span({className: 'minus'}, ' - '),
			            		html.span({className: 'case-name'},
			            			this.caseNameSpan = html.span(model.caseName || '')
			            		)
		            		),
		            		this.contentDiv = html.p({className: 'navbar-text pull-right'})
            			)
	                )
                )
            );
            this.parentNode.appendChild(markup);
            
            this.contentFragmentList = new FragmentList(this.contentDiv, this.engine);
            this.contentFragmentList.init(model.content);
    	},
    	
    	update: function (newModel, diff) {
    		ns.Presence.superclass.update.call(this, newModel, diff);
    		if (this.oldModel.caseName != newModel.caseName) {
    			this.caseNameSpan.set('text', newModel.caseName);
    		}
    		if (this.oldModel.userName != newModel.userName) {
    			this.loginNameSpan.set('text', newModel.userName);
    		}
    		
            ns.Presence.superclass.update.call(this, newModel, diff);
            this.contentFragmentList.update(newModel.content, diff);
    	}
    });
    
    // Me
    ns.Me = function (parentNode, engine) {
        ns.Me.superclass.constructor.apply(this, arguments);
    };
    
    Y.extend(ns.Me, Y.instantlogic.Fragment, {
    	init: function(model) {
    		ns.Me.superclass.init.call(this, model);
    		var markup = html.span({className: 'me'},
				this.avatarDiv = html.span({className: 'avatar'}, html.img({src:'/avatar.png'})),
				this.loginNameSpan = html.span({className: 'username'}, model.username || '')
    		)
    		this.parentNode.appendChild(markup);
    	}
    });
    
    // ShowCommunicatorButton
    ns.ShowCommunicatorButton = function(parentNode, engine) {
    	ns.ShowCommunicatorButton.superclass.constructor.apply(this, arguments);
    };
    
    Y.extend(ns.ShowCommunicatorButton, Y.instantlogic.Fragment, {
    	init: function(model) {
    		ns.ShowCommunicatorButton.superclass.init.call(this, model);
    		var markup = html.span({className: 'show-communicator-button'},
    			this.button = html.button({className:'btn'},'Communicator')
    		)
    		this.parentNode.appendChild(markup);
    		this.button.on('click', this.onClick, this);
    	},
    	onClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'setCommunicatorVisible', value:true});
    	}
    });
    
    // Communicator
    ns.Communicator = Y.instantlogic.createFragment({
    	createMarkup: function() {
    		var markup = html.div({className:'communicator'},
    			this.hideButton = html.button({className:'btn'},'Hide communicator'),
    			this.usersDiv = html.div()
    		)
    		this.hideButton.on('click', this.onHideClick, this);
            return markup;
    	},
    	fragmentLists: function(model) {
    		return [[this.usersDiv, model.users]];
    	},
    	overrides: {
        	onHideClick: function() {
        		this.engine.enqueueMessage({message: 'presence', command: 'setCommunicatorVisible', value:false});
        	}
    	}
    });

    // User
    ns.User = Y.instantlogic.createFragment({ 
    	createMarkup: function() {
    		return html.div({className:'user'},
    			this.usernameDiv = html.div()
    		);
    	},
    	texts: function(model) {
    		return [[this.usernameDiv, model.username]];
    	}
    });

    // Traveler
    ns.Traveler = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		return html.div({className:'traveler'},
    			this.travelernameDiv = html.div()
    		)
    		this.parentNode.appendChild(markup);
    	},
    	texts: function(model) {
    		return [[this.travelernameDiv, model.placeUrl]];
    	}
    });
    
    ns.DebugVisibleToggle = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		var markup = html.form({ action: '.', className: 'form-inline debug-visible' },
    			html.label({className:'checkbox'},
    				this.input = html.input({type:'checkbox'}), 'Debug'
    			)
    		);
    		this.input.on('change', this.inputChange, this);
    		return markup;
    	},
    	postInit: function(model) {
    		this.input.set('checked', model.value);
    		this.setDebug(model.value);
    	},
    	postUpdate: function(newModel, diff) {
    		if (newModel.value!=this.oldModel.value) {
    			this.input.set('checked', newModel.value);
        		this.setDebug(newModel.value);
    		}
    	},
    	overrides: {
            inputChange: function() {
            	this.engine.enqueueMessage({message: 'presence', command: 'setDebugVisible', value: this.input.get('checked')});
            },
            setDebug:function(newValue) {
            	var engine = this.engine;
            	if (engine.configuration.debug!=newValue) {
            		engine.configuration.debug = newValue;
            		setTimeout(function(){
            			engine.recomposePlace();
            		});
            	}
            }
    	}
    }); 

    // Login
    ns.Login = function(parentNode, engine) {
    	ns.Login.superclass.constructor.apply(this, arguments);
    }
    
    Y.extend(ns.Login, Y.instantlogic.Fragment, {
    	init: function(model) {
    		ns.Login.superclass.init.call(this, model);
    		var markup = html.div({className: 'login'},
				html.div({className: 'window'},
					html.h2('Please login'),
	    			html.div({className: 'input'},
		    			html.div({className: 'question'}, 'Username'),
		    			html.div({className: 'answer'},
		    				this.usernameInput = html.input({type: 'text'})
		    			)
	    			),
	    			html.div({className: 'buttons'},
	    				this.loginButton = html.button('Login')
	    			)
	    		)
    		);
    		this.loginButton.on('click', this.loginClick, this);
    	},
    	
    	loginClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
    	}
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });