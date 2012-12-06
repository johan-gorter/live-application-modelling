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

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("e66b79d7-74a2-4e8c-b9b4-ecf68bad8c8c", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("1a98a352-219c-495a-80a7-9ccd2c2c1b94", "Button")      .setStyleNames(new String[]{"btn-link"})
      .setEvent(org.instantlogic.example.izzy.event.HomeEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Home")))
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("b2f2ca79-424c-4ba8-b398-c8c593d12bfe", "Icon")      .setStyleNames(new String[]{"icon-home"})
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("dbade824-7487-4c07-8cc5-abe83c439e38", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                new org.instantlogic.interaction.page.FragmentTemplate("12061a40-7afe-4a79-b993-2a264e073462", "Input")      .setStyleNames(new String[]{"answer-span8"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.headline)
,
                new org.instantlogic.interaction.page.FragmentTemplate("72b89c5e-3e94-451b-8d36-ff13e0ecfca6", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.reporter)
,
                new org.instantlogic.interaction.page.FragmentTemplate("d332214f-a569-42a7-aa12-f90e93f269a9", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.assignee)
,
                new org.instantlogic.interaction.page.FragmentTemplate("f2b24da8-407e-48be-b546-a9e54ee54f50", "Input")      .setStyleNames(new String[]{"answer-span8", "answer-height300"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.description)
        )
; 
	
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "issueDetails";
    }
}