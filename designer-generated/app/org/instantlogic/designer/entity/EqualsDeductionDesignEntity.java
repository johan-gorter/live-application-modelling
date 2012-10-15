package org.instantlogic.designer.entity;

public class EqualsDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EqualsDeductionDesign> {

	public static final EqualsDeductionDesignEntity INSTANCE = new EqualsDeductionDesignEntity();
	
	
	protected EqualsDeductionDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.EqualsDeductionDesign createInstance() {
		return new org.instantlogic.designer.EqualsDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EqualsDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.EqualsDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "EqualsDeductionDesign";
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
