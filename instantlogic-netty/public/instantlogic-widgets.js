YUI.add('instantlogic-widgets', function(Y) {
	
	var widgetsNs = Y.namespace('instantlogic.widget');
	
	function Question(config) {
		Question.superclass.constructor.apply( this, arguments );
	}
	
	widgetsNs.Question = Y.extend(Question, Y.Widget, {
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
	},{
		NAME:'question', 
		ATTRS: {
			question: {value:null}
		}
	});
		
}, '3.4.1', { requires: ['instantlogic','html'] });