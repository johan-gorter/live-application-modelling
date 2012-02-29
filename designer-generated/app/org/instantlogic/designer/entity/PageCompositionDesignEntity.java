package org.instantlogic.designer.entity;

public class PageCompositionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.PageCompositionDesign> {

	public static final PageCompositionDesignEntity INSTANCE = new PageCompositionDesignEntity();
	
	protected PageCompositionDesignEntity() {
	}


	@Override
	public org.instantlogic.designer.PageCompositionDesign createInstance() {
		return new org.instantlogic.designer.PageCompositionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.PageCompositionDesign> getInstanceClass() {
		return org.instantlogic.designer.PageCompositionDesign.class;
	}
	
	@Override
	public String getName() {
		return "PageCompositionDesign";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentDesign> pageFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.PageFragmentDesign, org.instantlogic.designer.PageFragmentDesign>(
			"pageFragment", INSTANCE, org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE, org.instantlogic.designer.PageFragmentDesign.class, org.instantlogic.designer.entity.PageFragmentDesignEntity.composedIn
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.PageFragmentDesign> get(
					org.instantlogic.designer.PageCompositionDesign instance) {
				return instance.getPageFragmentRelation();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.CompositePageFragmentDesign> itemIn
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositePageFragmentDesign, org.instantlogic.designer.CompositePageFragmentDesign>(
			"itemIn", INSTANCE, org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.INSTANCE, org.instantlogic.designer.CompositePageFragmentDesign.class, org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.items
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositePageFragmentDesign> get(
					org.instantlogic.designer.PageCompositionDesign instance) {
				return instance.getItemInRelation();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		pageFragment,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		itemIn,
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
