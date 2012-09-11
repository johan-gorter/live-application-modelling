package org.instantlogic.designer;


public class DeductionSchemeDesign extends AbstractDeductionSchemeDesign {

	public DeductionDesign deduceSelectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		
		addToDeductions(selectedInstanceDeductionDesign);
		setOutput(selectedInstanceDeductionDesign);
		
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setJavaClassName(entity.getApplication().getRootPackageName()+"."+entity.getTechnicalNameCapitalized());
		return selectedInstanceDeductionDesign;
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute) {
		return attribute(attribute, null);
	}

	public DeductionDesign attribute(AttributeDesign attribute, DeductionDesign instanceDeduction) {
		if (instanceDeduction==null) {
			instanceDeduction = deduceSelectedInstance(attribute.getBelongsToEntity());
		}
		String className = attribute.getDataType().getJavaClassName();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getTechnicalNameCapitalized();
		}
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		
		addToDeductions(attributeDeductionDesign);
		setOutput(attributeDeductionDesign);
		
		attributeDeductionDesign.addToInputs(instanceDeduction);
		attributeDeductionDesign.setAttribute(attribute);
		if (attribute.getDataType().getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setJavaClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setJavaClassName(className);	
		}
		return attributeDeductionDesign;
		
	}

	public DeductionDesign deduceRelation(RelationDesign relation, DeductionDesign instance) {
		if (instance==null) {
			instance = deduceSelectedInstance(relation.getFrom());
		}
		return attribute(relation, instance);
	}

	public DeductionDesign deduceRelation(RelationDesign relation) {
		return deduceRelation(relation, null);
	}
}
