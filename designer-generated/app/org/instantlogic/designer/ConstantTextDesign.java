package org.instantlogic.designer;


public class ConstantTextDesign extends TextDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ConstantTextDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ConstantTextDesign, java.lang.String> untranslated
		= createAttributeValue(org.instantlogic.designer.entity.ConstantTextDesignEntity.untranslated);
	
	public java.lang.String getUntranslated() {
		return untranslated.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ConstantTextDesign, java.lang.String> getUntranslatedAttributeValue() {
		return untranslated;
	}

	public ConstantTextDesign setUntranslated(java.lang.String newValue) {
		untranslated.setValue(newValue);
		return (ConstantTextDesign)this;
	}
	
	
	// Relations

	// Reverse relations

}
