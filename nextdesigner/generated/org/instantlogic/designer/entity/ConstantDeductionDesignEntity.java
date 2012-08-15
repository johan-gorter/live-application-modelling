package org.instantlogic.designer.entity;

public class ConstantDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ConstantDeductionDesign> {

	public static final ConstantDeductionDesignEntity INSTANCE = new ConstantDeductionDesignEntity();
	
	protected ConstantDeductionDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.ConstantDeductionDesign createInstance() {
		return new org.instantlogic.designer.ConstantDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ConstantDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.ConstantDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "ConstantDeductionDesign";
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
