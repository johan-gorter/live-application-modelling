package org.instantlogic.designer;


public class StaticInstanceValueDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<StaticInstanceValueDesign, java.lang.Object> value
		= createAttributeValue(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.value);
	
	public java.lang.Object getValue() {
		return value.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<StaticInstanceValueDesign, java.lang.Object> getValueAttributeValue() {
		return value;
	}

	public StaticInstanceValueDesign setValue(java.lang.Object newValue) {
		value.setValue(newValue);
		return (StaticInstanceValueDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public StaticInstanceValueDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (StaticInstanceValueDesign)this;
	}
	
	public org.instantlogic.designer.AttributeDesign newAttribute() {
		org.instantlogic.designer.AttributeDesign newValue = new org.instantlogic.designer.AttributeDesign(); 
		attribute.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
