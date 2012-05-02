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
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign> pageFragment
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.FragmentTemplateDesign, org.instantlogic.designer.FragmentTemplateDesign>(
			"pageFragment", INSTANCE, org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTemplateDesign.class, org.instantlogic.designer.entity.PageFragmentDesignEntity.composedIn
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.FragmentTemplateDesign> get(
					org.instantlogic.designer.PageCompositionDesign instance) {
				return instance.getPageFragmentRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign> itemIn
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositeTemplateDesign, org.instantlogic.designer.CompositeTemplateDesign>(
			"itemIn", INSTANCE, org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.CompositeTemplateDesign.class, org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.items
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.PageCompositionDesign, org.instantlogic.designer.CompositeTemplateDesign> get(
					org.instantlogic.designer.PageCompositionDesign instance) {
				return instance.getItemInRelationValue();
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
