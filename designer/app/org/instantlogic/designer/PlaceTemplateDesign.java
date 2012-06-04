package org.instantlogic.designer;

public class PlaceTemplateDesign extends AbstractPlaceTemplateDesign {

	protected static ConstantTextDesign createConstantText(String untranslated) {
		ConstantTextDesign result = new ConstantTextDesign();
		result.setUntranslated(untranslated);
		return result;
	}
	
	protected static FragmentTemplateDesign createText(String fragmentTypeName, TextDesign text) {
		FragmentTemplateDesign result = new FragmentTemplateDesign();
		result.setFragmentTypeName(fragmentTypeName);
		result.setText("text", text);
		return result;
	}
}
