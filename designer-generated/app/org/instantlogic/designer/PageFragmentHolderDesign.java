package org.instantlogic.designer;


public class PageFragmentHolderDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PageFragmentHolderDesign, FragmentTemplateDesign> pageFragment
		= createRelationValue(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.pageFragment);
		
	public org.instantlogic.fabric.value.RelationValue<PageFragmentHolderDesign, FragmentTemplateDesign> getPageFragmentRelationValue() {
		return pageFragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getPageFragment() {
		return pageFragment.getValue();
	}
	
	public PageFragmentHolderDesign setPageFragment(org.instantlogic.designer.FragmentTemplateDesign newValue) {
		pageFragment.setValue(newValue);
		return (PageFragmentHolderDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> shared
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.shared);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> getSharedRelationValue() {
		return shared;
	}

	public org.instantlogic.designer.ApplicationDesign getShared() {
		return shared.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.PageFragmentHolderDesignEntity.usages);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> getUsagesRelationValue() {
		return usages;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedFragmentDesign> getUsages() {
		return usages.getValue();
	}


}
