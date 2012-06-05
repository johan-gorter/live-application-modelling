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
			"deductions", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.scheme
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
			"output", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.schemeOutput
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getOutputRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> compositeTemplate
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"compositeTemplate", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.selections
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getCompositeTemplateRelationValue();
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
				return instance.getDefaultOfAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"relevanceOfAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.relevance
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getRelevanceOfAttributeRelationValue();
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
				return instance.getRuleOfAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> selection
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
			"selection", INSTANCE, org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE, org.instantlogic.designer.SelectionDesign.class, org.instantlogic.designer.entity.SelectionDesignEntity.selection
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getSelectionRelationValue();
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
				return instance.getTemplatedTextRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> valueForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
			"valueForFragment", INSTANCE, org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE, org.instantlogic.designer.PropertyDesign.class, org.instantlogic.designer.entity.PropertyDesignEntity.deduction
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign> get(
					org.instantlogic.designer.DeductionSchemeDesign instance) {
				return instance.getValueForFragmentRelationValue();
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
		compositeTemplate,
		defaultOfAttribute,
		relevanceOfAttribute,
		ruleOfAttribute,
		selection,
		templatedText,
		valueForFragment,
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
