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

	public org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> getRequiredAttributeValue() {
		return required;
	}

	public FieldDesign setRequired(java.lang.Boolean newValue) {
		required.setValue(newValue);
		return (FieldDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> readOnly
		= createAttributeValue(org.instantlogic.designer.entity.FieldDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FieldDesign, java.lang.Boolean> getReadOnlyAttributeValue() {
		return readOnly;
	}

	public FieldDesign setReadOnly(java.lang.Boolean newValue) {
		readOnly.setValue(newValue);
		return (FieldDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FieldDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.FieldDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<FieldDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public FieldDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (FieldDesign)this;
	}


	// Reverse relations

}
