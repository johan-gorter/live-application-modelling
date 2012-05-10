YUI.add('instantlogic-widgets', function(Y) {
	
	var widgetsNs = Y.namespace('instantlogic.widget');

	// Page
	
	function Page(config) {
		Page.superclass.constructor.apply(this, arguments);
	}
	
	widgetsNs.Page = Y.extend(Page, Y.Widget, {
	    renderUI: function() {
	        var contentBox = this.get( 'contentBox' );
	        var h = Y.html;
	        
	        var markup = h.div({cssClass:'page'},
		        this.headerDiv = h.div({cssClass: 'header'}),
		        this.mainDiv = h.div({cssClass: 'main'})
	        )
	        
	        contentBox.appendChild(markup);
	    },
	    syncUI: function() {
	    	
	    }
	}, {
		NAME:'page', 
		ATTRS: {
			headerContent: {value:null},
			mainContent: {value:null},
		}
	});
	
	// Answer
	
	function Answer(config) {
		Answer.superclass.constructor.apply(this, arguments);
	}
	
	widgetsNs.Answer = Y.extend(Answer, Y.Widget, {
	    renderUI : function () {
	        var contentBox = this.get( 'contentBox' );
	        var h = Y.html;
	        
	        var markup = h.form({action:'.'},
		        this.question = h.div({cssClass: 'question'}),
		        this.answer = h.div({cssClass: 'answer'})
	        )
	        
	        this.question.setContent(this.get('question'));
	        this.answer.setContent('ANSWER)TODO');
	        
	        contentBox.appendChild(markup);
	    }
	}, {
		NAME:'answer', 
		ATTRS: {
			value: {value:null}
		}
	});
	
	// Paragraph
	
	function Paragraph(config) {
		Paragraph.superclass.constructor.apply(this, arguments);
	}
	
	widgetsNs.Paragraph = Y.extend(Paragraph, Y.Widget, {
		
		createNode: function() {
			return Y.html.p();
		}
		
	    renderUI : function () {
	        var contentBox = this.get('contentBox');
	        this.node = this.createNode();
	        contentBox.appendChild(this.node);
	    },
	    syncUI: function() {
	    	this.node.setContent(this.get('text'));
	    }
	},{
		NAME:'question', 
		ATTRS: {
			text: {value:null}
		}
	});
		
}, '3.4.1', { requires: ['instantlogic','html'] });