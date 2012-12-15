package org.instantlogic.example.izzy.flow.main;

public class NotLoggedInPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NotLoggedInPlaceTemplate INSTANCE = new NotLoggedInPlaceTemplate();

	@Override
	public String getId() {
		return "8e1dcfb5-436f-4829-bfea-584db36c64b4";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("5ff2c95e-7704-4bb3-844c-683fdf826a99", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("b8e22811-2e18-4bce-abb7-b079aab4a34d", "Paragraph")      
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