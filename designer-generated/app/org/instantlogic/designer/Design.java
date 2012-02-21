package org.instantlogic.designer;


public  class Design extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> getNameAttribute() {
		return name;
	}


	public void setName(java.lang.String newValue) {
		name.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> javaName
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.DesignEntity.javaName);
	
	public java.lang.String getJavaName() {
		return javaName.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> getJavaNameAttribute() {
		return javaName;
	}


	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> customization
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> getCustomizationAttribute() {
		return customization;
	}


	public void setCustomization(java.lang.String newValue) {
		customization.setValue(newValue);
	}
	
	// Relations

	// Reverse relations

}
