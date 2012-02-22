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


	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> getIsCustomizedAttribute() {
		return isCustomized;
	}


	public void setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
	}
	
	// Relations

	// Reverse relations

}
