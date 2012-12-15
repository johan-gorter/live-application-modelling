package org.instantlogic.example.izzy.flow.issue;

public class IssueDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final IssueDetailsPlaceTemplate INSTANCE = new IssueDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "issueDetails";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("ae323dac-0707-4544-9d2b-1d49601a8291", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("575e8fe4-bb84-4a93-bed7-b4c4d37b66f7", "Button")      .setStyleNames(new String[]{"btn-link"})
      .setEvent(org.instantlogic.example.izzy.event.HomeEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Home")))
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("15abcd01-80dd-417b-8138-2d1888bf9cdd", "Icon")      .setStyleNames(new String[]{"icon-home"})
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("3bf3e8af-36ae-4cd2-b451-e34a0c4c0039", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                new org.instantlogic.interaction.page.FragmentTemplate("b79dc1df-73e1-4dca-9b85-e68e3f4d85cc", "Input")      .setStyleNames(new String[]{"answer-span8"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.headline)
,
                new org.instantlogic.interaction.page.FragmentTemplate("33d1634c-aa92-4ce6-bd48-028b6e281c5a", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.reporter)
,
                new org.instantlogic.interaction.page.FragmentTemplate("557ac2ef-354a-4191-9380-c3a6aa6e92c6", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.assignee)
,
                new org.instantlogic.interaction.page.FragmentTemplate("5eaf7fca-72e9-4ec3-b1cf-f8a3db81609c", "Input")      .setStyleNames(new String[]{"answer-span8", "answer-height300"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.description)
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction2()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction3()));
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "issueDetails";
    }
}