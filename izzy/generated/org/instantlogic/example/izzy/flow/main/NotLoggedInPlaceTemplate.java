package org.instantlogic.example.izzy.flow.main;

public class NotLoggedInPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NotLoggedInPlaceTemplate INSTANCE = new NotLoggedInPlaceTemplate();

	@Override
	public String getId() {
		return "a2090ace-58d1-4242-b595-8a54aa8913ec";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("3ef76cf6-0315-4172-8c92-d998cf2b01e4", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("18e92734-c7c8-4722-ac1e-04714ae333f5", "Paragraph")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Please log in.")))
        )
; 
	
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "not logged in";
    }
}