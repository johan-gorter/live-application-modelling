package org.instantlogic.designer;


public class PageFragmentDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<PageFragmentDesign, java.lang.String> presentation
		= createAttributeValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.presentation);
	
	public java.lang.String getPresentation() {
		return presentation.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<PageFragmentDesign, java.lang.String> getPresentationAttributeValue() {
		return presentation;
	}

	public PageFragmentDesign setPresentation(java.lang.String newValue) {
		presentation.setValue(newValue);
		return (PageFragmentDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentDesign, PageFragmentHolderDesign> holder
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.holder);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentDesign, PageFragmentHolderDesign> getHolderRelationValue() {
		return holder;
	}

	public org.instantlogic.designer.PageFragmentHolderDesign getHolder() {
		return holder.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentDesign, PageCompositionDesign> composedIn
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.composedIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<PageFragmentDesign, PageCompositionDesign> getComposedInRelationValue() {
		return composedIn;
	}

	public org.instantlogic.designer.PageCompositionDesign getComposedIn() {
		return composedIn.getValue();
	}


}
