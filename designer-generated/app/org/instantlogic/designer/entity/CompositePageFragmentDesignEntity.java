package org.instantlogic.designer.entity;

public class CompositePageFragmentDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.CompositePageFragmentDesign> {

	public static final CompositePageFragmentDesignEntity INSTANCE = new CompositePageFragmentDesignEntity();
	
	protected CompositePageFragmentDesignEntity() {
	}

	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	@Override
	public org.instantlogic.designer.CompositePageFragmentDesign createInstance() {
		return new org.instantlogic.designer.CompositePageFragmentDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.CompositePageFragmentDesign> getInstanceClass() {
		return org.instantlogic.designer.CompositePageFragmentDesign.class;
	}
	
	@Override
	public String getName() {
		return "CompositePageFragmentDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>, org.instantlogic.designer.PageCompositionDesign> items
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>, org.instantlogic.designer.PageCompositionDesign>(
			"items", INSTANCE, org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE, org.instantlogic.designer.PageCompositionDesign.class, org.instantlogic.designer.entity.PageCompositionDesignEntity.itemIn
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.PageCompositionDesign> get(
					org.instantlogic.designer.CompositePageFragmentDesign instance) {
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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.PageDesign, org.instantlogic.designer.PageDesign> contentOfPage
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.PageDesign, org.instantlogic.designer.PageDesign>(
			"contentOfPage", INSTANCE, org.instantlogic.designer.entity.PageDesignEntity.INSTANCE, org.instantlogic.designer.PageDesign.class, org.instantlogic.designer.entity.PageDesignEntity.content
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.PageDesign> get(
					org.instantlogic.designer.CompositePageFragmentDesign instance) {
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
