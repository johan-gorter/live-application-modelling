package org.instantlogic.designer.entity;

public class TemplatedTextDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TemplatedTextDesign> {

	public static final TemplatedTextDesignEntity INSTANCE = new TemplatedTextDesignEntity();
	
	protected TemplatedTextDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.TextDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.TemplatedTextDesign createInstance() {
		return new org.instantlogic.designer.TemplatedTextDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.TemplatedTextDesign> getInstanceClass() {
		return org.instantlogic.designer.TemplatedTextDesign.class;
	}
	
	@Override
	public String getName() {
		return "TemplatedTextDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TemplatedTextDesign, java.util.List<org.instantlogic.designer.StringProducerDesign>, org.instantlogic.designer.StringProducerDesign> untranslated
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TemplatedTextDesign, java.util.List<org.instantlogic.designer.StringProducerDesign>, org.instantlogic.designer.StringProducerDesign>(
			"untranslated", INSTANCE, org.instantlogic.designer.entity.StringProducerDesignEntity.INSTANCE, org.instantlogic.designer.StringProducerDesign.class, org.instantlogic.designer.entity.StringProducerDesignEntity.untranslatedInTemplate
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.TemplatedTextDesign, org.instantlogic.designer.StringProducerDesign> get(
					org.instantlogic.designer.TemplatedTextDesign instance) {
				return instance.getUntranslatedRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		untranslated,
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
