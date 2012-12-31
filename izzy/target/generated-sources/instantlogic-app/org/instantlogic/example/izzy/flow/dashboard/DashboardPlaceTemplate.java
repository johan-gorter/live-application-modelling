package org.instantlogic.example.izzy.flow.dashboard;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	@Override
	public String getId() {
		return "fe3e5e3b-b093-4fc6-b896-3038379e05d3";
	}
	

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


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.username, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("04c56143-c0e5-4af2-8098-f31b4635f50d", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("abd22e85-fc0a-43ef-a664-c195f00b4e29", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("13531139-fd39-454d-8f5a-d7584699988d", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Assigned to me")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("c695b466-b4a3-4b66-9659-10a9d8aef844", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("503561d0-cfbc-4ea6-a07f-0d18302da86c", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("54661358-4a58-418f-ac09-1ea7579ff733", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("e8165635-104c-4b94-9495-5648ee217e92", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("dc9a2f7c-ae12-41dc-8439-96601101f027", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("8ccf8eb9-dc00-42e0-9dfe-3fdbe47c3698", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("ed98687b-b16b-4ec3-a09f-e33cc7b0a9ac", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("All issues")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("291cb0ba-bb07-405a-aaf8-305311832558", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("0e61a629-09e0-4ca3-b7d0-4879d3ae1db6", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("642fa367-e5ec-40de-a602-5ace1baa1e94", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("6625905f-59b5-40bf-b7ec-928dfcad9a5c", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("539295cd-b40a-45da-9e81-fbcbcc194f23", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("9e83db68-53a8-4f47-9ced-ab28c70336f5", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("bf700891-5618-41df-b5c1-77d64bfa895e", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Create issue")))
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard"));
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
        return "dashboard";
    }
}