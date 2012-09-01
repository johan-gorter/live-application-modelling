YUI.add('instantlogic-fragment', function (Y) {

    var ns = Y.namespace('instantlogic.fragment');
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
    
    function createFragment(options, overrides) {
    	var constructor = function(parentNode, engine) {
    		constructor.superclass.constructor.apply(this, arguments);
    	}
    	Y.extend(constructor, options.baseClass || Y.instantlogic.Fragment, overrides);
    	return constructor;
    }
    
    // Communicator
    ns.Communicator = createFragment({}, {
    	init: function(model) {
    		ns.Communicator.superclass.init.call(this, model);
    		var markup = html.div({className:'communicator'},
    			this.hideButton = html.button('Hide communicator'),
    			this.usersDiv = html.div()
    		)
    		this.parentNode.appendChild(markup);
    		this.hideButton.on('click', this.onHideClick, this);
            this.usersFragmentList = new FragmentList(this.usersDiv, this.engine);
            this.usersFragmentList.init(model.users);
    	},
    	update: function(newModel, diff) {
    		ns.Communicator.superclass.update.call(this, newModel);
            this.usersFragmentList.update(newModel.users, diff);
    	},
    	onHideClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'setCommunicatorVisible', value:false});
    	}
    });

    // User
    ns.User = createFragment({}, {
    	init: function(model) {
    		ns.User.superclass.init.call(this, model);
    		var markup = html.div({className:'user'},
    			this.usernameDiv = html.div(model.username || '')
    		)
    		this.parentNode.appendChild(markup);
    	},
    	update: function(newModel, diff) {
    	}
    });

    // Traveler
    ns.Traveler = createFragment({}, {
    	init: function(model) {
    		ns.Traveler.superclass.init.call(this, model);
    		var markup = html.div({className:'traveler'},
    			this.travelernameDiv = html.div(model.placeUrl || '')
    		)
    		this.parentNode.appendChild(markup);
    	},
    	update: function(newModel, diff) {
    		if (newModel.placeUrl != newModel.placeUrl) {
    			this.travelernameDiv.set('text', newModel.placeUrl || '')
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
    		this.parentNode.appendChild(markup);
    		this.loginButton.on('click', this.loginClick, this);
    	},
    	
    	loginClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
    	}
    });

    // Page
    ns.Page = function(parentNode, engine) {
        ns.Page.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Page, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Page.superclass.init.call(this, model);
            var markup = html.div({ className: 'page' },
                this.headerDiv = html.div({ className: 'header' }),
                this.mainDiv = html.div({ className: 'main' })
            );
            this.parentNode.appendChild(markup);
            this.headerFragmentList = new FragmentList(this.headerDiv, this.engine);
            this.headerFragmentList.init(model.headerContent);
            this.mainFragmentList = new FragmentList(this.mainDiv, this.engine);
            this.mainFragmentList.init(model.mainContent);
        },

        canUpdateFrom: function (newModel) {
            return ns.Page.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Page.superclass.update.call(this, newModel, diff);
            this.headerFragmentList.update(newModel.headerContent, diff);
            this.mainFragmentList.update(newModel.mainContent, diff);
        },

        destroy: function () {
            ns.Page.superclass.destroy.call(this);
            this.headerFragmentList.destroy();
            this.mainFragmentList.destroy();
        }
    });

    // Input
    ns.Input = function (parentNode, engine) {
        ns.Input.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Input, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Input.superclass.init.call(this, model);
            var markup = html.form({ action: '.' },
                this.questionDiv = html.div({ className: 'question' }),
                this.answerDiv = html.div({ className: 'answer' })
            );
            this.parentNode.appendChild(markup);
            this.questionDiv.set('text', model.question || '');
            this.value = this.render(model.value);
            this.initInput(model);
        },
        
        initInput: function (model) {
        	this.input = html.input({type:'text', value: this.value});
        	this.input.on('change', this.inputChange, this);
        	this.answerDiv.setContent(this.input);
        },

        canUpdateFrom: function (newModel) {
            return ns.Input.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Input.superclass.update.call(this, newModel, diff);
            if (this.oldModel.question != newModel.question) {
                this.question.set('text', model.question || '');
            }
            this.updateInput(newModel);
        },
        
        updateInput: function(newModel, diff) {
        	var newValue = this.render(newModel.value);
        	if (newValue!=this.value) {
        		this.input.set('value', newValue);
        	}
        },
        
        render: function(modelValue) {
        	return ''+modelValue;
        },
        
        parse: function(value) {
        	return value;
        },
        
        inputChange: function() {
        	this.engine.sendChange(this.model.id, this.parse(this.input.get('value')));
        },

        destroy: function () {
            ns.Input.superclass.destroy.call(this);
        }
    });
    
    // Link
    ns.Link = function (parentNode, engine) {
        ns.Link.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Link, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Link.superclass.init.call(this, model);
            this.node = html.a({href:'#'},
            	this.textSpan = html.span(),
            	this.contentSpan = html.span()
            )
            this.textSpan.set('text', model.text || '');
            this.contentList = new FragmentList(this.contentSpan, this.engine);
            this.contentList.init(model.content);
            this.node.on('click', this.onClick, this);
            this.parentNode.appendChild(this.node);
        },
        
        update: function (newModel, diff) {
            ns.Link.superclass.update.call(this, newModel, diff);
            if (this.oldModel.text != newModel.text) {
                this.textSpan.set('text', newModel.text || '');
            }
            this.contentList.update(newModel.content, diff);
        },
        
        onClick: function(e) {
            e.preventDefault();
            this.engine.sendSubmit(this.model.id);
        }
    });

    // Button
    ns.Button = function (parentNode, engine) {
        ns.Button.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Button, ns.Link, {
    });
    
    // Paragraph
    ns.Paragraph = function (parentNode, engine) {
        ns.Paragraph.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Paragraph, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Paragraph.superclass.init.call(this, model);
            this.node = this.createNode();
            this.node.set('text', model.text || '');
            this.parentNode.appendChild(this.node);
        },

        createNode: function () {
            return html.p();
        },

        update: function (newModel, diff) {
            ns.Paragraph.superclass.update.call(this, newModel, diff);
            if (this.oldModel.text != newModel.text) {
                this.node.set('text', newModel.text || '');
            }
        }
    });

    // Heading1
    ns.Heading1 = function (parentNode, engine) {
        ns.Heading1.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Heading1, ns.Paragraph, {
        createNode: function() {
            return html.h1();
        }
    });
    
    // Table
    ns.Table = function (parentNode, engine) {
        ns.Table.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Table, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Table.superclass.init.call(this, model);
            this.node = html.div({className: 'table'},
            	html.div({className: 'tableheader row'},
            		this.headerDiv = html.div({className:'cells'})
            	),
            	this.bodyDiv = html.div({className: 'tablebody'})
            );
            this.parentNode.appendChild(this.node);
            
            this.headerFragmentList = new FragmentList(this.headerDiv, this.engine);
            this.headerFragmentList.init(model.columns);
            this.bodyFragmentList = new FragmentList(this.bodyDiv, this.engine);
            this.bodyFragmentList.init(model.rows);
        },
        
        update: function (newModel, diff) {
            ns.Table.superclass.update.call(this, newModel, diff);
            this.headerFragmentList.update(newModel.columns, diff);
            this.bodyFragmentList.update(newModel.rows, diff);
        }
    });
    
    // Row
    ns.Row = function (parentNode, engine) {
        ns.Row.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Row, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Row.superclass.init.call(this, model);
            this.node = 
            	html.div({className: 'row'},
            		this.cellsDiv = html.div({className: 'cells'})
            	);
            this.parentNode.appendChild(this.node);
            
            this.cellsFragmentList = new FragmentList(this.cellsDiv, this.engine);
            this.cellsFragmentList.init(model.cells);
        },
        
        update: function (newModel, diff) {
            ns.Row.superclass.update.call(this, newModel, diff);
            this.cellsFragmentList.update(newModel.cells, diff);
        }
    });

    // Column
    ns.Column = function (parentNode, engine) {
        ns.Column.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Column, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Column.superclass.init.call(this, model);
            this.node = html.div({className:'column-header cell'});
            this.node.set('text', model.header || '');
            this.parentNode.appendChild(this.node);
        },

        update: function (newModel, diff) {
            ns.Column.superclass.update.call(this, newModel, diff);
            if (this.oldModel.header != newModel.header) {
                this.node.set('text', newModel.header || '');
            }
        }
    });

    // Cell
    ns.Cell = function (parentNode, engine) {
        ns.Cell.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Cell, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Cell.superclass.init.call(this, model);
            this.node = html.div({className: 'cell'});
            this.parentNode.appendChild(this.node);
            
            this.contentFragmentList = new FragmentList(this.node, this.engine);
            this.contentFragmentList.init(model.content);
        },
        
        update: function (newModel, diff) {
            ns.Cell.superclass.update.call(this, newModel, diff);
            this.contentFragmentList.update(newModel.content, diff);
        }
    });

            
}, '0.7.0', { requires: ['instantlogic', 'html'] });