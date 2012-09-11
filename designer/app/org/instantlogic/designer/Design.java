package org.instantlogic.designer;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;

public class Design extends AbstractDesign {

	@Deprecated
	protected static <V> DeductionSchemeDesign createConstantDeduction(Class<V> className, V value) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();
		constantDeductionDesign.setJavaClassName(className.getName());
		constantDeductionDesign.setValue(value);
		scheme.addToDeductions(constantDeductionDesign);
		scheme.setOutput(constantDeductionDesign);
		return scheme;
	}
	
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
