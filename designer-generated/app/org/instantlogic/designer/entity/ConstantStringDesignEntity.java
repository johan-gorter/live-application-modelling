package org.instantlogic.designer.entity;

public class ConstantStringDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ConstantStringDesign> {

	public static final ConstantStringDesignEntity INSTANCE = new ConstantStringDesignEntity();
	
	protected ConstantStringDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.StringProducerDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.ConstantStringDesign createInstance() {
		return new org.instantlogic.designer.ConstantStringDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ConstantStringDesign> getInstanceClass() {
		return org.instantlogic.designer.ConstantStringDesign.class;
	}
	
	@Override
	public String getName() {
		return "ConstantStringDesign";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ConstantStringDesign, java.lang.String, java.lang.String> constant 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ConstantStringDesign, java.lang.String, java.lang.String>(
			"constant", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ConstantStringDesign, java.lang.String> get(org.instantlogic.designer.ConstantStringDesign instance) {
				return instance.getConstantAttribute();
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		constant,
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
