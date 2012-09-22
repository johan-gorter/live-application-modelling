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
            var markup = html.div({ className: 'top-bar' },
            	html.div({className: 'top-bar-content'},
            		this.applicationNameSpan = html.div({className: 'application-name'},
            			model.applicationName || ''
            		),
            		html.div({className: 'minus'}, ' - '),
            		html.div({className: 'case-name'},
            			this.caseNameSpan = html.span(model.caseName || '')
            		),
                    this.contentDiv = html.div()
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
    		var markup = html.div({className: 'me'},
				this.avatarDiv = html.div({className: 'avatar'}, html.img({src:'/avatar.png'})),
				this.loginNameSpan = html.div({className: 'username'}, model.username || '')
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
    		var markup = html.div({className: 'show-communicator-button'},
    			this.button = html.button('Communicator')
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
    			this.hideButton = html.button('Hide communicator'),
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
    		this.parentNode.appendChild(markup);
    		this.loginButton.on('click', this.loginClick, this);
    	},
    	
    	loginClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
    	}
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html'] });