package org.instantlogic.designer.entity;

public class ConstantTextDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ConstantTextDesign> {

	public static final ConstantTextDesignEntity INSTANCE = new ConstantTextDesignEntity();
	
	protected ConstantTextDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.TextDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.ConstantTextDesign createInstance() {
		return new org.instantlogic.designer.ConstantTextDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ConstantTextDesign> getInstanceClass() {
		return org.instantlogic.designer.ConstantTextDesign.class;
	}
	
	@Override
	public String getName() {
		return "ConstantTextDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ConstantTextDesign, java.lang.String, java.lang.String> untranslated 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ConstantTextDesign, java.lang.String, java.lang.String>(
			"untranslated", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ConstantTextDesign, java.lang.String> get(org.instantlogic.designer.ConstantTextDesign instance) {
				return instance.getUntranslatedAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		untranslated,
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
