package com.instantlogic.mini;


public class MiniThing extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return com.instantlogic.mini.entity.MiniThingEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<MiniThing, java.lang.Float> miniProperty
		= createAttributeValue(com.instantlogic.mini.entity.MiniThingEntity.miniProperty);
	
	public java.lang.Float getMiniProperty() {
		return miniProperty.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<MiniThing, java.lang.Float> getMiniPropertyAttributeValue() {
		return miniProperty;
	}

	public MiniThing setMiniProperty(java.lang.Float newValue) {
		miniProperty.setValue(newValue);
		return (MiniThing)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<MiniThing, java.lang.Float> miniProperty2
		= createAttributeValue(com.instantlogic.mini.entity.MiniThingEntity.miniProperty2);
	
	public java.lang.Float getMiniProperty2() {
		return miniProperty2.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<MiniThing, java.lang.Float> getMiniProperty2AttributeValue() {
		return miniProperty2;
	}

	public MiniThing setMiniProperty2(java.lang.Float newValue) {
		miniProperty2.setValue(newValue);
		return (MiniThing)this;
	}
	
	
	// Relations

	// Reverse relations

}
