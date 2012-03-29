package org.instantlogic.designer;


public class CustomPageFragmentDesign extends CompositePageFragmentDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.CustomPageFragmentDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<CustomPageFragmentDesign, java.lang.String> implementationClassName
		= createAttributeValue(org.instantlogic.designer.entity.CustomPageFragmentDesignEntity.implementationClassName);
	
	public java.lang.String getImplementationClassName() {
		return implementationClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<CustomPageFragmentDesign, java.lang.String> getImplementationClassNameAttributeValue() {
		return implementationClassName;
	}

	public CustomPageFragmentDesign setImplementationClassName(java.lang.String newValue) {
		implementationClassName.setValue(newValue);
		return (CustomPageFragmentDesign)this;
	}
	
	
	// Relations

	// Reverse relations

}
