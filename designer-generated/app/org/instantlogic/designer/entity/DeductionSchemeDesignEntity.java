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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, java.util.List<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> deductions
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, java.util.List<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
			"deductions", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.scheme
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getDeductionsRelation();
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
			"output", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.schemeOutput
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getOutputRelation();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"relevanceOfAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.relevance
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getRelevanceOfAttributeRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> ruleOfAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"ruleOfAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.rule
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getRuleOfAttributeRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> defaultOfAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"defaultOfAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity._default
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getDefaultOfAttributeRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FormattedValueDesign, org.instantlogic.designer.FormattedValueDesign> templatedText
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FormattedValueDesign, org.instantlogic.designer.FormattedValueDesign>(
			"templatedText", INSTANCE, org.instantlogic.designer.entity.FormattedValueDesignEntity.INSTANCE, org.instantlogic.designer.FormattedValueDesign.class, org.instantlogic.designer.entity.FormattedValueDesignEntity.deduction
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FormattedValueDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getTemplatedTextRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectDesign, org.instantlogic.designer.SelectDesign> select
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectDesign, org.instantlogic.designer.SelectDesign>(
			"select", INSTANCE, org.instantlogic.designer.entity.SelectDesignEntity.INSTANCE, org.instantlogic.designer.SelectDesign.class, org.instantlogic.designer.entity.SelectDesignEntity.deduction
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getSelectRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deductions,
		output,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		relevanceOfAttribute,
		ruleOfAttribute,
		defaultOfAttribute,
		templatedText,
		select,
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
