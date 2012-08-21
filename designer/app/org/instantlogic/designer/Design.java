package org.instantlogic.designer;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;

public class Design extends AbstractDesign {

	// Create a deduction scheme for an attribute or a relation
	protected static DeductionSchemeDesign createDeduction(AttributeDesign attribute) {
		String className = attribute.getJavaClassName();
		EntityDesign source = attribute.getBelongsToEntity();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getTechnicalNameCapitalized();
			source = relation.getFrom();
		}
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(source);
		selectedInstanceDeductionDesign.setClassName(source.getApplication().getRootPackageName()+"."+source.getTechnicalNameCapitalized());
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		attributeDeductionDesign.setAttribute(attribute);
		attributeDeductionDesign.addToInputs(selectedInstanceDeductionDesign);
		if (attribute.getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setClassName(className);	
		}
		scheme.addToDeductions(selectedInstanceDeductionDesign);
		scheme.addToDeductions(attributeDeductionDesign);
		scheme.setOutput(attributeDeductionDesign);
		return scheme;
	}
	
	protected static <V> DeductionSchemeDesign createConstantDeduction(Class<V> className, V value) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();
		constantDeductionDesign.setClassName(className.getName());
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
