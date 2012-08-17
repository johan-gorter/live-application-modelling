package org.instantlogic.designer.entity;

public class TextTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TextTemplateDesign> {

	public static final TextTemplateDesignEntity INSTANCE = new TextTemplateDesignEntity();
	
	
	protected TextTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.TextTemplateDesign createInstance() {
		return new org.instantlogic.designer.TextTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.TextTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.TextTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "TextTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign> untranslated
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign>(
			"untranslated", INSTANCE, org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE, org.instantlogic.designer.StringTemplateDesign.class, 
			org.instantlogic.designer.entity.StringTemplateDesignEntity.untranslatedInTemplate
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StringTemplateDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getUntranslatedRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> descriptionOnStaticInstance
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
			"descriptionOnStaticInstance", INSTANCE, org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE, org.instantlogic.designer.StaticInstanceDesign.class, org.instantlogic.designer.entity.StaticInstanceDesignEntity.description
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getDescriptionOnStaticInstanceRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.DomainEntryDesign> displayOnDomainEntry
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.DomainEntryDesign>(
			"displayOnDomainEntry", INSTANCE, org.instantlogic.designer.entity.DomainEntryDesignEntity.INSTANCE, org.instantlogic.designer.DomainEntryDesign.class, org.instantlogic.designer.entity.DomainEntryDesignEntity.display
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.DomainEntryDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getDisplayOnDomainEntryRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> explanationOnAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"explanationOnAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.explanation
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getExplanationOnAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> questionOnAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"questionOnAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.question
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getQuestionOnAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> textForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
			"textForFragment", INSTANCE, org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE, org.instantlogic.designer.PropertyDesign.class, org.instantlogic.designer.entity.PropertyDesignEntity.text
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getTextForFragmentRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		untranslated,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		descriptionOnStaticInstance,
		displayOnDomainEntry,
		explanationOnAttribute,
		questionOnAttribute,
		textForFragment,
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
