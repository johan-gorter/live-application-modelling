package org.instantlogic.designer.entity;

public class SharedTextDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedTextDesign> {

	public static final SharedTextDesignEntity INSTANCE = new SharedTextDesignEntity();
	
	protected SharedTextDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.TextDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SharedTextDesign createInstance() {
		return new org.instantlogic.designer.SharedTextDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedTextDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedTextDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedTextDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
