package org.instantlogic.designer;

public class PlaceTemplateDesign extends AbstractPlaceTemplateDesign {

	public PlaceTemplateDesign() {}
	
	public PlaceTemplateDesign(String name) {
		setName(name);
	}
	
	public void init() {
	}
	
	protected static FragmentTemplateDesign createText(String fragmentTypeName, TextTemplateDesign text) {
		FragmentTemplateDesign result = new FragmentTemplateDesign();
		result.setFragmentTypeName(fragmentTypeName);
		result.setText("text", text);
		return result;
	}
	
	protected static FragmentTemplateDesign createLink(TextTemplateDesign text, EventDesign event) {
		FragmentTemplateDesign result = new FragmentTemplateDesign();
		result.setFragmentTypeName("Link");
		result.setText("text", text);
		result.setEvent(event);
		return result;
	}
	
}
