package org.instantlogic.designer;

public class AttributeDesign extends AbstractAttributeDesign {
	
	// Makes the API easier to use
	@Override
	public AttributeDesign setRelevance(DeductionSchemeDesign newValue) {
		setHasRelevance(true); // Needed for the GUI
		return super.setRelevance(newValue);
	}

	// Makes the API easier to use
	@Override
	public AttributeDesign setRule(DeductionSchemeDesign newValue) {
		setHasRule(true);
		return super.setRule(newValue);
	}

	// Makes the API easier to use
	@Override
	public AttributeDesign setDefault(DeductionSchemeDesign newValue) {
		setHasDefault(true);
		return super.setDefault(newValue);
	}

}
