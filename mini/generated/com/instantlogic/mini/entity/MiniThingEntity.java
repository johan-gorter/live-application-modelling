package com.instantlogic.mini.entity;

public class MiniThingEntity extends org.instantlogic.fabric.model.Entity<com.instantlogic.mini.MiniThing> {

	public static final MiniThingEntity INSTANCE = new MiniThingEntity();
	
	protected MiniThingEntity() {
	}


	@Override
	public com.instantlogic.mini.MiniThing createInstance() {
		return new com.instantlogic.mini.MiniThing();
	}
	
	@Override
	public Class<com.instantlogic.mini.MiniThing> getInstanceClass() {
		return com.instantlogic.mini.MiniThing.class;
	}
	
	@Override
	public String getName() {
		return "MiniThing";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<com.instantlogic.mini.MiniThing, java.lang.Float, java.lang.Float> miniProperty 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<com.instantlogic.mini.MiniThing, java.lang.Float, java.lang.Float>(
			"miniProperty", INSTANCE, java.lang.Float.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<com.instantlogic.mini.MiniThing, java.lang.Float> get(com.instantlogic.mini.MiniThing instance) {
				return instance.getMiniPropertyAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<com.instantlogic.mini.MiniThing, java.lang.Float, java.lang.Float> miniProperty2 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<com.instantlogic.mini.MiniThing, java.lang.Float, java.lang.Float>(
			"miniProperty2", INSTANCE, java.lang.Float.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<com.instantlogic.mini.MiniThing, java.lang.Float> get(com.instantlogic.mini.MiniThing instance) {
				return instance.getMiniProperty2AttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<com.instantlogic.mini.MiniThing, org.instantlogic.fabric.value.Multi<com.instantlogic.mini.MiniThing>, com.instantlogic.mini.MiniThing> children
		= new org.instantlogic.fabric.model.impl.SimpleRelation<com.instantlogic.mini.MiniThing, org.instantlogic.fabric.value.Multi<com.instantlogic.mini.MiniThing>, com.instantlogic.mini.MiniThing>(
			"children", INSTANCE, com.instantlogic.mini.entity.MiniThingEntity.INSTANCE, com.instantlogic.mini.MiniThing.class, com.instantlogic.mini.entity.MiniThingEntity.parent
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing> get(
					com.instantlogic.mini.MiniThing instance) {
				return instance.getChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing> parent
		= new org.instantlogic.fabric.model.impl.SimpleRelation<com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing>(
			"parent", INSTANCE, com.instantlogic.mini.entity.MiniThingEntity.INSTANCE, com.instantlogic.mini.MiniThing.class, com.instantlogic.mini.entity.MiniThingEntity.children
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<com.instantlogic.mini.MiniThing, com.instantlogic.mini.MiniThing> get(
					com.instantlogic.mini.MiniThing instance) {
				return instance.getParentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		miniProperty,
		miniProperty2,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		children,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		parent,
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
