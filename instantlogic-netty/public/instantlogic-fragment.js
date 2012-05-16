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

        canUpdateFrom: function (newModel) {
            return ns.Paragraph.superclass.canUpdateFrom.call(this, newModel);
        },

        update: function (newModel, diff) {
            ns.Paragraph.superclass.update.call(this, newModel, diff);
            if (this.previousModel.text != newModel.text) {
                this.node.set('text', newModel.text);
            }
        },

        destroy: function () {
            ns.Paragraph.superclass.destroy.call(this);
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
}, '3.4.1', { requires: ['instantlogic', 'html'] });