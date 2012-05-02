package org.instantlogic.designer;


public class FragmentTemplateDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> presentation
		= createAttributeValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.presentation);
	
	public java.lang.String getPresentation() {
		return presentation.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> getPresentationAttributeValue() {
		return presentation;
	}

	public FragmentTemplateDesign setPresentation(java.lang.String newValue) {
		presentation.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PageFragmentHolderDesign> holder
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.holder);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PageFragmentHolderDesign> getHolderRelationValue() {
		return holder;
	}

	public org.instantlogic.designer.PageFragmentHolderDesign getHolder() {
		return holder.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PageCompositionDesign> composedIn
		= createReverseRelationValue(org.instantlogic.designer.entity.PageFragmentDesignEntity.composedIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PageCompositionDesign> getComposedInRelationValue() {
		return composedIn;
	}

	public org.instantlogic.designer.PageCompositionDesign getComposedIn() {
		return composedIn.getValue();
	}


}
