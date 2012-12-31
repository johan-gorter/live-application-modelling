package org.instantlogic.example.izzy.flow.main;

public class NotLoggedInPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NotLoggedInPlaceTemplate INSTANCE = new NotLoggedInPlaceTemplate();

	@Override
	public String getId() {
		return "3adf8135-a85f-46b4-8576-f64b4fea1a8e";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("c3189095-d378-4938-b99d-ec6d6cdc2de0", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("ed677de6-822f-4f05-ad96-bb5e5353b244", "Paragraph")      
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