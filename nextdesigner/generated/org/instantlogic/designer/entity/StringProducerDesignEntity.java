package org.instantlogic.designer.entity;

public class StringProducerDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StringProducerDesign> {

	public static final StringProducerDesignEntity INSTANCE = new StringProducerDesignEntity();
	
	protected StringProducerDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.StringProducerDesign createInstance() {
		return new org.instantlogic.designer.StringProducerDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.StringProducerDesign> getInstanceClass() {
		return org.instantlogic.designer.StringProducerDesign.class;
	}
	
	@Override
	public String getName() {
		return "StringProducerDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StringProducerDesign, org.instantlogic.designer.TemplatedTextDesign, org.instantlogic.designer.TemplatedTextDesign> untranslatedInTemplate
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringProducerDesign, org.instantlogic.designer.TemplatedTextDesign, org.instantlogic.designer.TemplatedTextDesign>(
			"untranslatedInTemplate", INSTANCE, org.instantlogic.designer.entity.TemplatedTextDesignEntity.INSTANCE, org.instantlogic.designer.TemplatedTextDesign.class, org.instantlogic.designer.entity.TemplatedTextDesignEntity.untranslated
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.StringProducerDesign, org.instantlogic.designer.TemplatedTextDesign> get(
					org.instantlogic.designer.StringProducerDesign instance) {
				return instance.getUntranslatedInTemplateRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		untranslatedInTemplate,
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
