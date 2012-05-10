package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.WidgetFragmentTemplate("F42P1W1", "Page")      
        .putChildren("headerContent",
                new org.instantlogic.interaction.page.WidgetFragmentTemplate("F42P1W1W1W1", "Text")      
                .putText("text", new org.instantlogic.fabric.text.ConstantText("Welcome"))
        )      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.WidgetFragmentTemplate("F42P1W1W2W1", "Text")      
                .putText("text", new org.instantlogic.fabric.text.ConstantText("Welcome to the Designer"))
        ); 
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Welcome";
    }
}