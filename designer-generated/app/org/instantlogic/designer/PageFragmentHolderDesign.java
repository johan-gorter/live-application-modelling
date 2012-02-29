package org.instantlogic.designer;


public  class PageFragmentHolderDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PageFragmentHolderDesign, PageFragmentDesign> pageFragment
		= createRelationValue(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.pageFragment);
		
	public org.instantlogic.fabric.value.RelationValue<PageFragmentHolderDesign, PageFragmentDesign> getPageFragmentRelation() {
		return pageFragment;
	}

	public org.instantlogic.designer.PageFragmentDesign getPageFragment() {
		return pageFragment.get();
	}
	
	public void setPageFragment(org.instantlogic.designer.PageFragmentDesign newValue) {
		pageFragment.setValue(newValue);
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> shared
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.shared);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> getSharedRelation() {
		return shared;
	}

	public org.instantlogic.designer.ApplicationDesign getShared() {
		return shared.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.usages);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> getUsagesRelation() {
		return usages;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedFragmentDesign> getUsages() {
		return usages.get();
	}


}
