package org.instantlogic.designer.entity;

public class DeductionSchemeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionSchemeDesign> {

	public static final DeductionSchemeDesignEntity INSTANCE = new DeductionSchemeDesignEntity();
	
	
	protected DeductionSchemeDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.DeductionSchemeDesign createInstance() {
		return new org.instantlogic.designer.DeductionSchemeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionSchemeDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionSchemeDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionSchemeDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> deductions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
			"deductions", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, 
			org.instantlogic.designer.entity.DeductionDesignEntity.scheme
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getDeductionsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> output
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
			"output", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getOutputRelationValue();
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deductions,
		output,
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
