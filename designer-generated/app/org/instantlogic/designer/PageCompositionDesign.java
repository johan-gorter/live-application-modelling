package org.instantlogic.designer;


public class PageCompositionDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PageCompositionDesign, FragmentTemplateDesign> pageFragment
		= createRelationValue(org.instantlogic.designer.entity.PageCompositionDesignEntity.pageFragment);
		
	public org.instantlogic.fabric.value.RelationValue<PageCompositionDesign, FragmentTemplateDesign> getPageFragmentRelationValue() {
		return pageFragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getPageFragment() {
		return pageFragment.getValue();
	}
	
	public PageCompositionDesign setPageFragment(org.instantlogic.designer.FragmentTemplateDesign newValue) {
		pageFragment.setValue(newValue);
		return (PageCompositionDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageCompositionDesign, CompositeTemplateDesign> itemIn
		= createReverseRelationValue(org.instantlogic.designer.entity.PageCompositionDesignEntity.itemIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageCompositionDesign, CompositeTemplateDesign> getItemInRelationValue() {
		return itemIn;
	}

	public org.instantlogic.designer.CompositeTemplateDesign getItemIn() {
		return itemIn.getValue();
	}


}
