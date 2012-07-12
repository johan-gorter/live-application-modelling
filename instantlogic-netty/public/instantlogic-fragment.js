YUI.add('instantlogic-fragment', function (Y) {

    var ns = Y.namespace('instantlogic.fragment');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // Page

    ns.Page = function (parentNode, fragmentFactory) {
        ns.Page.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Page, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Page.superclass.init.call(this, model);
            var markup = html.div({ cssClass: 'page' },
                this.headerDiv = html.div({ cssClass: 'header' }),
                this.mainDiv = html.div({ cssClass: 'main' })
            );
            this.parentNode.appendChild(markup);
            this.headerFragmentList = new FragmentList(this.headerDiv, this.fragmentFactory);
            this.headerFragmentList.init(model.headerContent);
            this.mainFragmentList = new FragmentList(this.mainDiv, this.fragmentFactory);
            this.mainFragmentList.init(model.mainContent);
        },

        canUpdateFrom: function (newModel) {
            return ns.Page.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Page.superclass.update.call(this, newModel, diff);
            this.headerFragmentList.update(newModel.headerContent);
            this.mainFragmentList.update(newModel.mainContent);
        },

        destroy: function () {
            ns.Page.superclass.destroy.call(this);
            this.headerFragmentList.destroy();
            this.mainFragmentList.destroy();
        }
    });

    // Answer
    ns.Answer = function (parentNode, fragmentFactory) {
        ns.Answer.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Answer, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Answer.superclass.init.call(this, model);
            var markup = html.form({ action: '.' },
                this.question = html.div({ cssClass: 'question' }),
                this.answer = html.div({ cssClass: 'answer' })
            );
            this.parentNode.appendChild(markup);
            this.question.set('text', model.question);
            this.answer.setContent('ANSWER_TODO');
        },

        canUpdateFrom: function (newModel) {
            return ns.Answer.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Answer.superclass.update.call(this, newModel, diff);
            if (this.previousModel.question != newModel.question) {
                this.question.set('text', model.question);
            }
        },

        destroy: function () {
            ns.Answer.superclass.destroy.call(this);
        }
    });
    
    // Link
    ns.Link = function (parentNode, fragmentFactory) {
        ns.Link.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Link, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Link.superclass.init.call(this, model);
            this.node = html.a({href:'#'});
            this.node.set('text', model.text);
            this.node.on('click', this.onClick, this);
            this.parentNode.appendChild(this.node);
        },
        
        onClick: function(e) {
            e.preventDefault();
            this.fragmentFactory.sendEvent(this.model.id);
        },

        update: function (newModel, diff) {
            ns.Link.superclass.update.call(this, newModel, diff);
            if (this.previousModel.text != newModel.text) {
                this.node.set('text', newModel.text);
            }
        }
    });

    // Button
    ns.Button = function (parentNode, fragmentFactory) {
        ns.Button.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Button, ns.Link, {
    });
    
    // Paragraph
    ns.Paragraph = function (parentNode, fragmentFactory) {
        ns.Paragraph.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Paragraph, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Paragraph.superclass.init.call(this, model);
            this.node = this.createNode();
            this.node.set('text', model.text);
            this.parentNode.appendChild(this.node);
        },

        createNode: function () {
            return html.p();
        },

        update: function (newModel, diff) {
            ns.Paragraph.superclass.update.call(this, newModel, diff);
            if (this.previousModel.text != newModel.text) {
                this.node.set('text', newModel.text);
            }
        }
    });

    // Heading1
    ns.Heading1 = function (parentNode, fragmentFactory) {
        ns.Heading1.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Heading1, ns.Paragraph, {
        createNode: function() {
            return html.h1();
        }
    });
    
    // Table
    ns.Table = function (parentNode, fragmentFactory) {
        ns.Table.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Table, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Table.superclass.init.call(this, model);
            this.node = html.div({cssClass: 'table'},
            	this.headerDiv = html.div({cssClass: 'header'}),
            	this.bodyDiv = html.div({cssClass: 'body'})
            );
            this.parentNode.appendChild(this.node);
            
            this.headerFragmentList = new FragmentList(this.headerDiv, this.fragmentFactory);
            this.headerFragmentList.init(model.columns);
            this.bodyFragmentList = new FragmentList(this.bodyDiv, this.fragmentFactory);
            this.bodyFragmentList.init(model.rows);
        },
        
        update: function (newModel, diff) {
            ns.Table.superclass.update.call(this, newModel, diff);
            this.headerFragmentList.update(newModel.columns);
            this.bodyFragmentList.update(newModel.rows);
        }
    });
    
    // Row
    ns.Row = function (parentNode, fragmentFactory) {
        ns.Row.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Row, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Row.superclass.init.call(this, model);
            this.node = html.div({cssClass: 'Row'});
            this.parentNode.appendChild(this.node);
            
            this.cellsFragmentList = new FragmentList(this.node, this.fragmentFactory);
            this.cellsFragmentList.init(model.cells);
        },
        
        update: function (newModel, diff) {
            ns.Row.superclass.update.call(this, newModel, diff);
            this.cellsFragmentList.update(newModel.cells);
        }
    });

    // Column
    ns.Column = function (parentNode, fragmentFactory) {
        ns.Column.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Column, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Column.superclass.init.call(this, model);
            this.node = html.div({cssClass:'ColumnHeader'});
            this.node.set('text', model.header);
            this.parentNode.appendChild(this.node);
        },

        update: function (newModel, diff) {
            ns.Column.superclass.update.call(this, newModel, diff);
            if (this.previousModel.header != newModel.header) {
                this.node.set('text', newModel.header);
            }
        }
    });

    // Cell
    ns.Cell = function (parentNode, fragmentFactory) {
        ns.Cell.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Cell, Y.instantlogic.Fragment, {
        init: function (model) {
            ns.Cell.superclass.init.call(this, model);
            this.node = html.div({cssClass: 'Cell'});
            this.parentNode.appendChild(this.node);
            
            this.contentFragmentList = new FragmentList(this.node, this.fragmentFactory);
            this.contentFragmentList.init(model.content);
        },
        
        update: function (newModel, diff) {
            ns.Cell.superclass.update.call(this, newModel, diff);
            this.contentFragmentList.update(newModel.content);
        }
    });

            
}, '0.7.0', { requires: ['instantlogic', 'html'] });