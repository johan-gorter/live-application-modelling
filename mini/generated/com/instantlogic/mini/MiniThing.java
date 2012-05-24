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
	
	private final org.instantlogic.fabric.value.RelationValues<MiniThing, MiniThing> children
		= createRelationValues(com.instantlogic.mini.entity.MiniThingEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<MiniThing, MiniThing> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<com.instantlogic.mini.MiniThing> getChildren() {
		return children.getValue();
	}
	
	public MiniThing addToChildren(MiniThing item) {
		children.addValue(item);
		return (MiniThing)this;
	}
	
	public MiniThing addToChildren(MiniThing item, int index) {
		children.insertValue(item, index);
		return (MiniThing)this;
	}
	
	public MiniThing removeFromChildren(MiniThing item) {
		children.removeValue(item);
		return (MiniThing)this;
	}
	
	public MiniThing removeFromChildren(int index) {
		children.removeValue(index);
		return (MiniThing)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<MiniThing, MiniThing> parent
		= createReverseRelationValue(com.instantlogic.mini.entity.MiniThingEntity.parent);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<MiniThing, MiniThing> getParentRelationValue() {
		return parent;
	}

	public com.instantlogic.mini.MiniThing getParent() {
		return parent.getValue();
	}


}
