package org.instantlogic.designer;


public class CustomDeductionDesign extends DeductionDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CustomDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<CustomDeductionDesign, java.lang.String> implementationClassName
		= createAttributeValue(org.instantlogic.designer.entity.CustomDeductionDesignEntity.implementationClassName);
	
	public java.lang.String getImplementationClassName() {
		return implementationClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<CustomDeductionDesign, java.lang.String> getImplementationClassNameAttributeValue() {
		return implementationClassName;
	}

	public CustomDeductionDesign setImplementationClassName(java.lang.String newValue) {
		implementationClassName.setValue(newValue);
		return (CustomDeductionDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<CustomDeductionDesign, DataTypeDesign> customDataType
		= createRelationValue(org.instantlogic.designer.entity.CustomDeductionDesignEntity.customDataType);
		
	public org.instantlogic.fabric.value.RelationValue<CustomDeductionDesign, DataTypeDesign> getCustomDataTypeRelationValue() {
		return customDataType;
	}

	public org.instantlogic.designer.DataTypeDesign getCustomDataType() {
		return customDataType.getValue();
	}
	
	public CustomDeductionDesign setCustomDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		customDataType.setValue(newValue);
		return (CustomDeductionDesign)this;
	}


	// Reverse relations

}
