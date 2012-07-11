package org.instantlogic.example.izzy.flow.main;

public class DashboardPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DashboardPlaceTemplate INSTANCE = new DashboardPlaceTemplate();

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F1P2F1", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F1P2F1P1F1", "Button")        )
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