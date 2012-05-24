package org.instantlogic.designer.entity;

public class PlaceTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PlaceTemplateDesign> {

	public static final PlaceTemplateDesignEntity INSTANCE = new PlaceTemplateDesignEntity();
	
	protected PlaceTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.PlaceTemplateDesign createInstance() {
		return new org.instantlogic.designer.PlaceTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PlaceTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.PlaceTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "PlaceTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> content
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"content", INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.contentOfPage
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.PlaceTemplateDesign instance) {
				return instance.getContentRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		content,
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
