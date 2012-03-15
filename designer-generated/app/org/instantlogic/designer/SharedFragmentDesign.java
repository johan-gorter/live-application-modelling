package org.instantlogic.designer;


public class SharedFragmentDesign extends PageFragmentDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SharedFragmentDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SharedFragmentDesign, PageFragmentHolderDesign> pageFragmentHolder
		= createRelationValue(org.instantlogic.designer.entity.SharedFragmentDesignEntity.pageFragmentHolder);
		
	public org.instantlogic.fabric.value.RelationValue<SharedFragmentDesign, PageFragmentHolderDesign> getPageFragmentHolderRelationValue() {
		return pageFragmentHolder;
	}

	public org.instantlogic.designer.PageFragmentHolderDesign getPageFragmentHolder() {
		return pageFragmentHolder.getValue();
	}
	
	public SharedFragmentDesign setPageFragmentHolder(org.instantlogic.designer.PageFragmentHolderDesign newValue) {
		pageFragmentHolder.setValue(newValue);
		return (SharedFragmentDesign)this;
	}


	// Reverse relations

}
