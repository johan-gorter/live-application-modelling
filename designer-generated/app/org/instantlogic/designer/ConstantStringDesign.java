package org.instantlogic.designer;


public class ConstantStringDesign extends StringProducerDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ConstantStringDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ConstantStringDesign, java.lang.String> constant
		= createAttributeValue(org.instantlogic.designer.entity.ConstantStringDesignEntity.constant);
	
	public java.lang.String getConstant() {
		return constant.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ConstantStringDesign, java.lang.String> getConstantAttribute() {
		return constant;
	}


	public void setConstant(java.lang.String newValue) {
		constant.setValue(newValue);
	}
	
	// Relations

	// Reverse relations

}
