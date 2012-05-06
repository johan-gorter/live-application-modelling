package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create("header");
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create("paragraph");
		return d0;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.WidgetFragmentTemplate("W1", "Page")      
        .putChildren("headerContent",
                new org.instantlogic.interaction.page.WidgetFragmentTemplate("W1", "text")      
                .putValue("role", createDeduction0())      
                .putText("text", new org.instantlogic.fabric.text.ConstantText("Welcome"))
        )      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.WidgetFragmentTemplate("W1", "Text")      
                .putValue("role", createDeduction1())      
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