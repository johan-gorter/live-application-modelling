YUI.add('instantlogic-fragments', function (Y) {

    var ns = Y.namespace('instantlogic.fragments');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;
    var createFragment = Y.instantlogic.createFragment;

    // Page
    ns.Page = createFragment({
    	createMarkup: function() {
    		var markup = html.div({ className: 'container' },
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
    	},
    	postUpdate: function(newModel) {
    		if (newModel.title!=this.oldModel.title) {
    			document.title = newModel.title || '';
    		}
    	},
    	overrides: {
    	}
    });
    
    // Input
    ns.Input = createFragment({ 
    	createMarkup: function() {
    		return html.form({ action: '.', className: 'form-horizontal' },
	        	html.div({className: 'control-group'},
	                this.questionDiv = html.div({ className: 'control-label' }),
	                this.answerDiv = html.div({ className: 'controls' })
	            )
    		);
    	},
    	texts: function(model) {
    		return [[this.questionDiv, model.questionText]];
    	},
    	postInit: function(model) {
            this.initInput(model);
    	},
    	postUpdate: function(newModel, diff) {
            this.updateInput(newModel);
    	},
    	overrides: {
            initInput: function (model) {
            	this.answer = this.engine.createAnswer(model);
            	this.input = this.answer.createMarkup();
            	this.answer.updateValue(model.value);
            	this.answerDiv.setContent(this.input);
            	this.answerDiv.on('change', this.inputChange, this);
            },
            updateInput: function(newModel, diff) {
            	if (newModel.value!=this.oldModel.value) {
            		this.answer.updateValue(newModel.value);
            	}
            },
            inputChange: function() {
            	this.engine.sendChange(this.model.id, this.answer.getValue());
            }
    	}
    });
    
    // Link
    ns.Link = createFragment({
    	createMarkup: function() {
            return this.node = html.a({href:'#', className: this.cssClassName()},
            	this.textSpan = html.span(),
            	this.contentSpan = html.span()
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
    
    // Table
    ns.Table = function (parentNode, engine) {
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
            	html.div({className: 'divtable-row'},
            		this.cellsDiv = html.div({className: 'divtable-cells'})
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
    ns.Cell = function (parentNode, engine) {
        ns.Cell.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Cell, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Cell.superclass.init.call(this, model);
            this.node = html.div({className: 'divtable-cell'});
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