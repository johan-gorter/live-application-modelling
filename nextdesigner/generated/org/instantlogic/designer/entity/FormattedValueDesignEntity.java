package org.instantlogic.designer.entity;

public class FormattedValueDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.FormattedValueDesign> {

	public static final FormattedValueDesignEntity INSTANCE = new FormattedValueDesignEntity();
	
	protected FormattedValueDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.StringProducerDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.FormattedValueDesign createInstance() {
		return new org.instantlogic.designer.FormattedValueDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.FormattedValueDesign> getInstanceClass() {
		return org.instantlogic.designer.FormattedValueDesign.class;
	}
	
	@Override
	public String getName() {
		return "FormattedValueDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.FormattedValueDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.FormattedValueDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.templatedText
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.FormattedValueDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.FormattedValueDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
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
