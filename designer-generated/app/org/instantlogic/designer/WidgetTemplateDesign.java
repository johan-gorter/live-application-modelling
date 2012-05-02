package org.instantlogic.designer;


public class WidgetTemplateDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.Boolean> required
		= createAttributeValue(org.instantlogic.designer.entity.FieldDesignEntity.required);
	
	public java.lang.Boolean getRequired() {
		return required.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.Boolean> getRequiredAttributeValue() {
		return required;
	}

	public WidgetTemplateDesign setRequired(java.lang.Boolean newValue) {
		required.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.Boolean> readOnly
		= createAttributeValue(org.instantlogic.designer.entity.FieldDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.Boolean> getReadOnlyAttributeValue() {
		return readOnly;
	}

	public WidgetTemplateDesign setReadOnly(java.lang.Boolean newValue) {
		readOnly.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.FieldDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public WidgetTemplateDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}


	// Reverse relations

}
