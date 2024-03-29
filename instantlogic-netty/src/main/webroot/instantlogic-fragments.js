YUI.add('instantlogic-fragments', function (Y) {

    var ns = Y.namespace('instantlogic.fragments');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;
    var createFragment = Y.instantlogic.createFragment;
    var util = Y.instantlogic.util;

    // Page
    ns.Page = createFragment({
    	createMarkup: function() {
    		var markup = html.div({ className: 'page-outer container' },
    			html.div({ className: 'page' },
	                this.headerDiv = html.div({ className: 'header' }),
	                this.mainDiv = html.div({ className: 'main' })
                )
            );
    		return markup;
    	},
    	fragmentLists: function(model) {
    		return [
    		    [this.headerDiv, model.headerContent], 
    		    [this.mainDiv, model.mainContent]
    		];
    	},
    	postInit: function(model) {
    		document.title = model.title || '';
    		if (model.themeNames) {
    			for (var i=0;i<model.themeNames.length;i++) {
    				this.markup.addClass(model.themeNames[i]);
    			}
    		}
    	},
    	postUpdate: function(newModel, diff) {
    		if (newModel.title!=this.oldModel.title) {
    			document.title = newModel.title || '';
    		}
    		if (!util.arrayEquals(this.oldModel.themeNames, newModel.themeNames)) {
	    		if (this.oldModel.themeNames) {
	    			for (var i=0;i<this.oldModel.themeNames.length;i++) {
	    				this.markup.removeClass(this.oldModel.themeNames[i]);
	    			}
	    		}
	    		if (newModel.themeNames) {
	    			for (var i=0;i<newModel.themeNames.length;i++) {
	    				this.markup.addClass(newModel.themeNames[i]);
	    			}
	    		}
	    		diff.nodeUpdated(this.markup);
    		}
    	},
    	overrides: {
    	}
    });
    
    // Input
    ns.Input = createFragment({ 
    	createMarkup: function() {
    		return html.div({className: 'animate-vertically'},
	    		html.form({ action: '.', className: 'form-horizontal input' },
		        	html.div({className: 'control-group'},
		                this.questionDiv = html.div({ className: 'control-label' }),
		                this.answerDiv = html.div({ className: 'controls' })
		            )
	    		)
    		);
    	},
    	texts: function(model) {
    		return [[this.questionDiv, model.questionText]];
    	},
    	postInit: function(model) {
        	this.answer = this.engine.createAnswer(model);
        	this.answerMarkup = this.answer.createMarkup();
        	this.answer.updateValue(model.value);
    		if (model.styleNames) {
    			for (var i=0;i<model.styleNames.length;i++) {
    				var name = model.styleNames[i];
    				if (name.substr(0,7)=='answer-') {
    					this.markup.removeClass(name);
    					this.answerMarkup.addClass(name.substr(7));
    				}
    			}
    		}
        	this.answerDiv.setContent(this.answerMarkup);
        	this.answerDiv.on('change', this.inputChange, this);
        	this.answerDiv.on('focus', this.inputFocus, this);
    	},
    	postUpdate: function(newModel, diff) {
        	if (newModel.value!=this.oldModel.value) {
        		this.answer.updateValue(newModel.value);
        	}
    		if (!util.arrayEquals(this.oldModel.styleNames, newModel.styleNames)) {
	    		if (this.oldModel.styleNames) {
	    			for (var i=0;i<this.oldModel.styleNames.length;i++) {
	    				var name = this.oldModel.styleNames[i];
	    				if (name.substr(0,7)=='answer-') {
	    					this.answerMarkup.removeClass(name.substr(7));
	    				}
	    			}
	    		}
	    		if (newModel.styleNames) {
	    			for (var i=0;i<newModel.styleNames.length;i++) {
	    				var name = newModel.styleNames[i];
	    				if (name.substr(0,7)=='answer-') {
	    					this.markup.removeClass(name);	    					
	    					this.answerMarkup.addClass(name.substr(7));
	    				}
	    			}
	    		}
	    		diff.nodeUpdated(this.markup);
    		}
    	},
    	overrides: {
            inputChange: function() {
            	this.engine.sendChange(this.model.id, this.answer.getValue());
            },
            inputFocus: function() {
            	this.engine.enqueueMessage({message: 'presence', command: 'setFocus', value: this.model.id});
            }
    	}
    });
    
    ns.Icon = createFragment({
    	createMarkup: function() {
    		return html.i(); // A styleName of icon-something is expected here
    	}
    }),
    
    // Link
    ns.Link = createFragment({
    	createMarkup: function() {
            return this.node = html.a({href:'#', className: this.cssClassName()},
            	this.contentSpan = html.span(),
            	this.textSpan = html.span()
            )
    	},
    	texts: function(model) {
    		return [[this.textSpan, model.text]];
    	},
    	fragmentLists: function(model) {
    		return [[this.contentSpan, model.content]];
    	},
    	postInit: function(model) {
    		this.node.on('click', this.onClick, this);
    	},
    	overrides: {
    		cssClassName: function() {
    			return 'link';
    		},
            onClick: function(e) {
                e.preventDefault();
                this.engine.sendSubmit(this.model.id);
            }
    	}
    });
    
    // Button
    ns.Button = createFragment({
    	baseClass: ns.Link,
    	overrides: {
    		cssClassName: function() {
    			return 'btn';
    		}
    	}
    });

    // Group: Just renders its content, essentially just a span.
    ns.Group = createFragment({
    	createMarkup: function() {
    		return html.span();
    	},
		fragmentLists: function(model) {
			return [[this.markup, model.content]];
		}
    });
    
    // Block: Renders its content on a new line, essentially just a div.
    ns.Block = createFragment({
    	createMarkup: function() {
    		return html.div({className: 'animate-vertically'});
    	},
		fragmentLists: function(model) {
			return [[this.markup, model.content]];
		}
    });

    // Text: just a span. Subclasses can implement createNode
    ns.Text = createFragment({
    	createMarkup: function() {
    		var result = this.createNode();
    		this.textSpan = html.span();
			result.appendChild(this.textSpan);
			return result;
    	},
    	texts: function(model) {
    		return [[this.textSpan, model.text]];
    	},
    	overrides: {
	        createNode: function () {
	            return html.span(); // Baseclasses can override this to provide a p, h1, etc...
	        }
    	}
    });
    
    // Paragraph
    ns.Paragraph = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.p();
            }
    	}
    });

    // Heading1
    ns.Heading1 = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.h1();
            }
    	}
    });

    // Heading2
    ns.Heading2 = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.h2();
            }
    	}
    });
    
    // Heading3
    ns.Heading3 = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.h3();
            }
    	}
    });
    
    // Heading4
    ns.Heading4 = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.h4();
            }
    	}
    });
    
    // Heading5
    ns.Heading5 = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.h5();
            }
    	}
    });
    
    // Strong
    ns.Strong = createFragment({
    	baseClass: ns.Text,
    	overrides: {
            createNode: function() {
                return html.strong();
            }
    	}
    });

    ns.PresenceIndicator = createFragment({
    	createMarkup: function() {
    		return html.div({className: 'presence-indicator'});
    	},
    	postInit: function(model) {
    		if (!this.engine.communicator) Y.error('No communicator registered from which to obtain presence indicator information');
    		this.lastInstanceId = model.id.substr(model.id.lastIndexOf('!')+1);
    		this.lastInstanceId = this.lastInstanceId.substr(0, this.lastInstanceId.indexOf('+'));
    		this.updateImages();
    		var me = this;
    		this.onTravelersUpdate = function() {
    			me.updateImages();
    		}
    		this.engine.communicator.subscribe(this.onTravelersUpdate);
    	},
    	overrides: {
    		updateImages: function() {
    			this.markup.get('children').remove();
    			var usernames = this.engine.communicator.findTravelersInPlace(this.lastInstanceId);
    			for (var i=0; i<usernames.length;i++) {
    				var username = usernames[i];
    				this.markup.appendChild(html.img({src:'/avatar/'+username+'.jpg', width:'20', height:'20', style:'width:20px;height:20px;'}));
    			}
    		},
    		destroy: function() {
    			this.engine.communicator.unsubscribe(this.onTravelersUpdate);
    		}
    	}
    });
    
    // Table
    ns.Table = function (parentNode, parentFragment, engine) {
        ns.Table.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Table, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Table.superclass.init.call(this, model);
            this.node = html.div({className: 'divtable'},
            	html.div({className: 'tableheader divtable-row'},
            		this.headerDiv = html.div({className:'divtable-cells'})
            	),
            	this.bodyDiv = html.div({className: 'tablebody'})
            );
            this.parentNode.appendChild(this.node);
            
            this.headerFragmentList = new FragmentList(this.headerDiv, this, this.engine);
            this.headerFragmentList.init(model.columns);
            this.bodyFragmentList = new FragmentList(this.bodyDiv, this, this.engine);
            this.bodyFragmentList.init(model.rows);
        },
        
        update: function (newModel, diff) {
            ns.Table.superclass.update.call(this, newModel, diff);
            this.headerFragmentList.update(newModel.columns, diff);
            this.bodyFragmentList.update(newModel.rows, diff);
        }
    });
    
    // Row
    ns.Row = function (parentNode, parentFragment, engine) {
        ns.Row.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Row, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Row.superclass.init.call(this, model);
            this.node = 
            	html.div({className: 'animate-vertically'},
	            	html.div({className: 'divtable-row'},
	            		this.cellsDiv = html.div({className: 'divtable-cells'})
	            	)
            	);
            this.parentNode.appendChild(this.node);
            
            this.cellsFragmentList = new FragmentList(this.cellsDiv, this, this.engine);
            this.cellsFragmentList.init(model.cells);
        },
        
        update: function (newModel, diff) {
            ns.Row.superclass.update.call(this, newModel, diff);
            this.cellsFragmentList.update(newModel.cells, diff);
        }
    });

    // Column
    ns.Column = function (parentNode, parentFragment, engine) {
        ns.Column.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Column, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Column.superclass.init.call(this, model);
            this.node = html.div({className:'divtable-column-header divtable-cell'});
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
    ns.Cell = createFragment({
    	createMarkup: function() {
            return this.node = html.div({className:'divtable-cell'},
            	this.contentSpan = html.span(),
            	this.textSpan = html.span()
            )
    	},
    	texts: function(model) {
    		return [[this.textSpan, model.text]];
    	},
    	fragmentLists: function(model) {
    		return [[this.contentSpan, model.content]];
    	}
    });
   
            
}, '0.7.0', { requires: ['instantlogic', 'html'] });