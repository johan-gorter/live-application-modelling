package org.instantlogic.designer;


public class Design extends org.instantlogic.fabric.Instance { 

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

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> getNameAttributeValue() {
		return name;
	}

	public Design setName(java.lang.String newValue) {
		name.setValue(newValue);
		return (Design)this;
	}
	
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> javaName
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.DesignEntity.javaName);
	
	public java.lang.String getJavaName() {
		return javaName.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> getJavaNameAttributeValue() {
		return javaName;
	}

	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> getIsCustomizedAttributeValue() {
		return isCustomized;
	}

	public Design setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
		return (Design)this;
	}
	
	
	// Relations

	// Reverse relations

}
