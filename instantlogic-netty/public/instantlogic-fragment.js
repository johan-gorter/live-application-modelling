YUI.add('instantlogic-fragment', function (Y) {

    var ns = Y.namespace('instantlogic.fragment');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // Page

    ns.Page = function (parentNode, engine) {
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

    // Answer
    ns.Answer = function (parentNode, engine) {
        ns.Answer.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Answer, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Answer.superclass.init.call(this, model);
            var markup = html.form({ action: '.' },
                this.question = html.div({ className: 'question' }),
                this.answer = html.div({ className: 'answer' })
            );
            this.parentNode.appendChild(markup);
            this.question.set('text', model.question || '');
            this.answer.setContent('ANSWER_TODO');
        },

        canUpdateFrom: function (newModel) {
            return ns.Answer.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Answer.superclass.update.call(this, newModel, diff);
            if (this.previousModel.question != newModel.question) {
                this.question.set('text', model.question || '');
            }
        },

        destroy: function () {
            ns.Answer.superclass.destroy.call(this);
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
            if (this.previousModel.text != newModel.text) {
                this.textSpan.set('text', newModel.text || '');
            }
            this.contentList.update(newModel.content, diff);
        },
        
        onClick: function(e) {
            e.preventDefault();
            this.engine.sendEvent(this.model.id);
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
            if (this.previousModel.text != newModel.text) {
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
            if (this.previousModel.header != newModel.header) {
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