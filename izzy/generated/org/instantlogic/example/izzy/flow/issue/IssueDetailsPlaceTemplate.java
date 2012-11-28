package org.instantlogic.example.izzy.flow.issue;

public class IssueDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final IssueDetailsPlaceTemplate INSTANCE = new IssueDetailsPlaceTemplate();


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
        new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F1", "Button")      .setStyleNames(new String[]{"btn-link"})
      .setEvent(org.instantlogic.example.izzy.event.HomeEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Home")))
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F1P1F1", "Icon")      .setStyleNames(new String[]{"icon-home"})
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F2", "Heading1")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue "),new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(": "),new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F3", "Input")      .setStyleNames(new String[]{"answer-span8"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.headline)
,
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F4", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.reporter)
,
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F5", "Input")      .setStyleNames(new String[]{"answer-span4"})
      .setField(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.assignee)
,
                new org.instantlogic.interaction.page.FragmentTemplate("F11P1F1P1F6", "Input")      .setStyleNames(new String[]{"answer-span8", "answer-rows-40"})
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