package org.instantlogic.example.izzy.flow.main;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F7P3F1", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F7P3F1P1F1", "Button")      .setEvent(org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE)
      
                .putText("text", new org.instantlogic.fabric.text.ConstantText("Create issue"))
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