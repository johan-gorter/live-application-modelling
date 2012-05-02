package org.instantlogic.designer.entity;

public class SelectDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SelectDesign> {

	public static final SelectDesignEntity INSTANCE = new SelectDesignEntity();
	
	protected SelectDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.SelectDesign createInstance() {
		return new org.instantlogic.designer.SelectDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SelectDesign> getInstanceClass() {
		return org.instantlogic.designer.SelectDesign.class;
	}
	
	@Override
	public String getName() {
		return "SelectDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.select
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SelectDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.SelectDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deduction,
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
