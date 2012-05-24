package org.instantlogic.designer.entity;

public class TextDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TextDesign> {

	public static final TextDesignEntity INSTANCE = new TextDesignEntity();
	
	protected TextDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.TextDesign createInstance() {
		return new org.instantlogic.designer.TextDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.TextDesign> getInstanceClass() {
		return org.instantlogic.designer.TextDesign.class;
	}
	
	@Override
	public String getName() {
		return "TextDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> questionOnAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"questionOnAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.question
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.TextDesign instance) {
				return instance.getQuestionOnAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> explanationOnAttribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"explanationOnAttribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, org.instantlogic.designer.entity.AttributeDesignEntity.explanation
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.TextDesign instance) {
				return instance.getExplanationOnAttributeRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.DomainEntryDesign> displayOnDomainEntry
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.DomainEntryDesign, org.instantlogic.designer.DomainEntryDesign>(
			"displayOnDomainEntry", INSTANCE, org.instantlogic.designer.entity.DomainEntryDesignEntity.INSTANCE, org.instantlogic.designer.DomainEntryDesign.class, org.instantlogic.designer.entity.DomainEntryDesignEntity.display
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextDesign, org.instantlogic.designer.DomainEntryDesign> get(
					org.instantlogic.designer.TextDesign instance) {
				return instance.getDisplayOnDomainEntryRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.FragmentText, org.instantlogic.designer.FragmentText> textForFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextDesign, org.instantlogic.designer.FragmentText, org.instantlogic.designer.FragmentText>(
			"textForFragment", INSTANCE, org.instantlogic.designer.entity.FragmentTextEntity.INSTANCE, org.instantlogic.designer.FragmentText.class, org.instantlogic.designer.entity.FragmentTextEntity.text
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextDesign, org.instantlogic.designer.FragmentText> get(
					org.instantlogic.designer.TextDesign instance) {
				return instance.getTextForFragmentRelationValue();
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
		questionOnAttribute,
		explanationOnAttribute,
		displayOnDomainEntry,
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
