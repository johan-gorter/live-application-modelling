package org.instantlogic.designer;


public class PageCompositionDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PageCompositionDesign, PageFragmentDesign> pageFragment
		= createRelationValue(org.instantlogic.designer.entity.PageCompositionDesignEntity.pageFragment);
		
	public org.instantlogic.fabric.value.RelationValue<PageCompositionDesign, PageFragmentDesign> getPageFragmentRelation() {
		return pageFragment;
	}

	public org.instantlogic.designer.PageFragmentDesign getPageFragment() {
		return pageFragment.getValue();
	}
	
	public void setPageFragment(org.instantlogic.designer.PageFragmentDesign newValue) {
		pageFragment.setValue(newValue);
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageCompositionDesign, CompositePageFragmentDesign> itemIn
		= createReverseRelationValue(org.instantlogic.designer.entity.PageCompositionDesignEntity.itemIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageCompositionDesign, CompositePageFragmentDesign> getItemInRelation() {
		return itemIn;
	}

	public org.instantlogic.designer.CompositePageFragmentDesign getItemIn() {
		return itemIn.getValue();
	}


}
