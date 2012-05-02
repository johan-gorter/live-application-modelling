package org.instantlogic.designer.entity;

public class PlaceDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PlaceTemplateDesign> {

	public static final PlaceDesignEntity INSTANCE = new PlaceDesignEntity();
	
	protected PlaceDesignEntity() {
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
		return "PageDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign> content
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign>(
			"content", INSTANCE, org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.CompositeTemplateDesign.class, org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.contentOfPage
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign> get(
					org.instantlogic.designer.PlaceTemplateDesign instance) {
				return instance.getContentRelationValue();
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
