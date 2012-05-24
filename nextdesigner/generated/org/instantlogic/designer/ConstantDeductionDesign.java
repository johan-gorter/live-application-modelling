package org.instantlogic.designer;


public class ConstantDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ConstantDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ConstantDeductionDesign, java.lang.Object> value
		= createAttributeValue(org.instantlogic.designer.entity.ConstantDeductionDesignEntity.value);
	
	public java.lang.Object getValue() {
		return value.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ConstantDeductionDesign, java.lang.Object> getValueAttributeValue() {
		return value;
	}

	public ConstantDeductionDesign setValue(java.lang.Object newValue) {
		value.setValue(newValue);
		return (ConstantDeductionDesign)this;
	}
	
	
	// Relations

	// Reverse relations

}
