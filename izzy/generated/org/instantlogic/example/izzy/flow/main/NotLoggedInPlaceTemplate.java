package org.instantlogic.example.izzy.flow.main;

public class NotLoggedInPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NotLoggedInPlaceTemplate INSTANCE = new NotLoggedInPlaceTemplate();

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("79ffe887-a004-4c15-a6b6-baf311ddb0bf", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("f46ad95b-0778-4656-b379-c46faf44aed0", "Paragraph")      
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