package org.instantlogic.designer;


public class FieldDesign extends PageFragmentDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> required
		= createAttributeValue(org.instantlogic.designer.entity.FieldDesignEntity.required);
	
	public java.lang.Boolean getRequired() {
		return required.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> getRequiredAttribute() {
		return required;
	}

	public void setRequired(java.lang.Boolean newValue) {
		required.setValue(newValue);
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> readOnly
		= createAttributeValue(org.instantlogic.designer.entity.FieldDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> getReadOnlyAttribute() {
		return readOnly;
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.setValue(newValue);
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FieldDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.FieldDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<FieldDesign, AttributeDesign> getAttributeRelation() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public void setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
	}


	// Reverse relations

}
