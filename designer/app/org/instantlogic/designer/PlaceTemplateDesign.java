package org.instantlogic.designer;

public class PlaceTemplateDesign extends AbstractPlaceTemplateDesign {

	public PlaceTemplateDesign() {}
	
	public PlaceTemplateDesign(String name) {
		setName(name);
	}
	
	public void init() {
	}
	
    public PlaceTemplateDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
    	super.setOwner(newValue);
    	return this;
    }
}
