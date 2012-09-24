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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> titleOfPlaceTemplate
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
			"titleOfPlaceTemplate", INSTANCE, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE, org.instantlogic.designer.PlaceTemplateDesign.class, org.instantlogic.designer.entity.PlaceTemplateDesignEntity.title
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> get(
					org.instantlogic.designer.TextTemplateDesign instance) {
				return instance.getTitleOfPlaceTemplateRelationValue();
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
		titleOfPlaceTemplate,
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
