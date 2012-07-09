package org.instantlogic.designer;

public class Design extends AbstractDesign {

	// Create a deduction scheme for an attribute or a relation
	protected static DeductionSchemeDesign createDeduction(AttributeDesign attribute) {
		String className = attribute.getClassName();
		EntityDesign source = attribute.getBelongsToEntity();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getName();
			source = relation.getFrom();
		}
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(source);
		selectedInstanceDeductionDesign.setClassName(source.getApplication().getRootPackageName()+"."+source.getName());
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
	
	public String getTechnicalNameCapitalized() {
		StringBuffer result = new StringBuffer(getTechnicalName());
		result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
		return result.toString();
	}
}
