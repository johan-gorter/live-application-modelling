package org.instantlogic.example.izzy.flow.dashboard;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.username, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.assignee, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Project> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.ProjectEntity.issues, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("d0e3bb69-1d97-4051-8f31-b313b12af38c", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("3ecfc23e-468c-441c-9b27-bf291f3cde90", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("22c8dbed-2cd2-408b-8d35-c97ef3e0ea1f", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Assigned to me")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("ca8c09f8-3b76-4169-a705-467c77ebda00", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("bc9d8ae3-1c5c-4835-accb-3345404e93dc", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("239f5510-8d4b-40cf-a084-0c8c4bf5f77b", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("e854de6f-8254-49c0-a7e2-910cd9d40d30", "Column")      .setStyleNames(new String[]{"issuePreview"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                    org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("7404f2e6-6e55-4ffc-ba1e-b392701d2893", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("All issues")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("63725811-f026-4a40-9c13-a5a5d029575c", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("372245d8-d154-48e7-895d-fb016ad77692", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("fe517b4c-9542-42dc-8e07-cebd998e66c6", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("80f349ed-d25b-4483-a7a9-9965bf179034", "Column")      .setStyleNames(new String[]{"issuePreview"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                    org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("948a7d41-ff35-44b0-82f4-a2319bd4cbb9", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Create issue")))
        )
; 
	
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "dashboard";
    }
}