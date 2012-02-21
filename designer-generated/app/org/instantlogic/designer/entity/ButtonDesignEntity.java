package org.instantlogic.designer.entity;

public class ButtonDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ButtonDesign> {

	public static final ButtonDesignEntity INSTANCE = new ButtonDesignEntity();
	
	protected ButtonDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.LinkDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.ButtonDesign createInstance() {
		return new org.instantlogic.designer.ButtonDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ButtonDesign> getInstanceClass() {
		return org.instantlogic.designer.ButtonDesign.class;
	}
	
	@Override
	public String getName() {
		return "ButtonDesign";
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
