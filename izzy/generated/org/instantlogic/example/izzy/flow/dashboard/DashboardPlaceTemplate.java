package org.instantlogic.example.izzy.flow.dashboard;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	@Override
	public String getId() {
		return "ea7e32e8-aa99-476d-bcca-f5559ef4b635";
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
        new org.instantlogic.interaction.page.FragmentTemplate("bfac744e-904f-47d8-a109-914b0a0ac9e3", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("35ab22cb-b59e-4710-9040-be174c931a89", "Heading2")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate("'s dashboard")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("32b4cb7d-ccd9-4320-b62f-9dc2f9b7cc37", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Assigned to me")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("dab277dd-530f-4d9d-9e07-67b7fb67b2ab", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("a0ed1d38-5e68-4bcd-95d1-b526641c5dc2", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("6a97c335-57d5-4c69-922f-4724c9bb0a47", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("5101152a-5ef7-4c0a-9393-21180144f9a6", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("1f39cc85-fc71-4350-9005-111cf9226c8f", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("fef20d98-6fa7-46ea-b84c-981556bcc3bc", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("838e4b1d-6d5a-426e-8e2b-a247754a462a", "Heading4")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("All issues")))
,
                new org.instantlogic.interaction.page.FragmentTemplate("6600d56f-16ee-4f5a-9eb3-420bd5eb33b6", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("745e7991-a114-4322-9fa3-66294bf0fdd5", "Column")      .setStyleNames(new String[]{"issueNr"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("#")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("ab240443-c0b4-4710-8c52-9fe384764065", "Column")      .setStyleNames(new String[]{"issueHeadline"})
      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Issue")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("c68c3cff-322f-4af7-a7f2-3bb00c2ed7b3", "Column")      .setStyleNames(new String[]{"issuePreview"})
,
                        new org.instantlogic.interaction.page.FragmentTemplate("c1805f94-81c7-4d1e-9248-ef0a7c7b4dde", "Column")      .setStyleNames(new String[]{"presence-indicator"})
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                    new org.instantlogic.interaction.page.SharedElementHolder("6648625e-0f71-4148-9004-35ffaf828688", org.instantlogic.example.izzy.sharedpagefragment.IssueRowPageFragment.INSTANCE)
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("dd62ae60-14ea-496a-ba91-3eb11a9c795d", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
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