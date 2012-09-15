package org.instantlogic.designer;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;

public class Design extends AbstractDesign {

	protected static TextTemplateDesign createConstantText(String untranslated) {
		TextTemplateDesign result = new TextTemplateDesign();
		StringTemplateDesign stringTemplateDesign = new StringTemplateDesign();
		stringTemplateDesign.setConstantText(untranslated);
		result.addToUntranslated(stringTemplateDesign);
		return result;
	}
	
	public String getTechnicalNameCapitalized() {
		return TechnicalNameDeduction.capitalizeFirst(getTechnicalName());
	}
}
