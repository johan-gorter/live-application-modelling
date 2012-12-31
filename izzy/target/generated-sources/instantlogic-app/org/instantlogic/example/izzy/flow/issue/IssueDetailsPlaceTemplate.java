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
        new org.instantlogic.interaction.page.FragmentTemplate("f7c320b1-1ed9-4619-8e4a-60c65d970c5a", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("5e09504c-7baa-4407-be70-b3526f24505d", "Button")      .setStyleNames(new String[]{"btn-link"})
      .setEvent(org.instantlogic.example.izzy.event.HomeEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Home")))
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("339fde9a-2c08-4955-9b03-1ed2aa5f6bad", "Icon")      .setStyleNames(new String[]{"icon-home"})
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("10d1b7c6-e375-4ff7-aab0-954ef49ceda1", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                new org.instantlogic.interaction.page.FragmentTemplate("0c180494-6950-4ee9-bf28-f8b703d28d38", "Input")      .setStyleNames(new String[]{"answer-span8"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.headline)
,
                new org.instantlogic.interaction.page.FragmentTemplate("72568233-0423-4429-8cdb-ef489ddf8c27", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.reporter)
,
                new org.instantlogic.interaction.page.FragmentTemplate("784e5528-97ff-4f37-87ac-99357c800363", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.assignee)
,
                new org.instantlogic.interaction.page.FragmentTemplate("d7e57733-c755-4657-ba7e-86f32c506ee1", "Input")      .setStyleNames(new String[]{"answer-span8", "answer-height300"})
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