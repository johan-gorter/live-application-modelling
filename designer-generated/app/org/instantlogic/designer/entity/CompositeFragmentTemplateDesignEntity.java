package org.instantlogic.designer.entity;

public class CompositeFragmentTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.CompositeTemplateDesign> {

	public static final CompositeFragmentTemplateDesignEntity INSTANCE = new CompositeFragmentTemplateDesignEntity();
	
	protected CompositeFragmentTemplateDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.CompositeTemplateDesign createInstance() {
		return new org.instantlogic.designer.CompositeTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.CompositeTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.CompositeTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "CompositeFragmentTemplateDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>, org.instantlogic.designer.PageCompositionDesign> items
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>, org.instantlogic.designer.PageCompositionDesign>(
			"items", INSTANCE, org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE, org.instantlogic.designer.PageCompositionDesign.class, org.instantlogic.designer.entity.PageCompositionDesignEntity.itemIn
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.PageCompositionDesign> get(
					org.instantlogic.designer.CompositeTemplateDesign instance) {
				return instance.getItemsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> contentOfPage
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
			"contentOfPage", INSTANCE, org.instantlogic.designer.entity.PlaceDesignEntity.INSTANCE, org.instantlogic.designer.PlaceTemplateDesign.class, org.instantlogic.designer.entity.PlaceDesignEntity.content
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> get(
					org.instantlogic.designer.CompositeTemplateDesign instance) {
				return instance.getContentOfPageRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		items,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		contentOfPage,
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
