package org.instantlogic.example.izzy.flow.dashboard;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	@Override
	public String getId() {
		return "ed34b2f4-a2a4-495e-88e7-96cda4642976";
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

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("544d7cb8-aa9e-4e82-b4fa-525ee3f187be", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("5eba140e-b5dd-4a66-a58a-185b57dfc4b4", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("3cfd0af6-d0e8-4fe7-aa7e-84a39046ced4", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Assigned to me")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("bc82548b-dbd6-4e12-a3ab-3ebfea98d7b3", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("5eb67ba1-2800-49f9-80f6-87aafedabc5f", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("4e6086fa-eb0f-4393-a3fc-6f10efce8eca", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("4bfb766c-9d19-40e8-bd43-0af0135e4aad", "Column")      .setStyleNames(new String[]{"issuePreview"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                    org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("d96abf3c-c165-4880-b689-914e7158e424", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("All issues")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("2553df92-f929-4d00-854e-7e0c54575cf4", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("8093f67b-ea6b-4dfb-b978-58f2c9631451", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("251c3e9b-934f-470f-82e8-304e10750ffb", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("c7b00a19-82aa-4a16-a77d-3fa08d85f8a2", "Column")      .setStyleNames(new String[]{"issuePreview"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                    org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("24e13784-1d54-49c4-9656-2cb4560ea4ee", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
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