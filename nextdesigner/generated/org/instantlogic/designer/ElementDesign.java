package org.instantlogic.designer;


public class ElementDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, SelectionDesign> childOfSelection
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.childOfSelection);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, SelectionDesign> getChildOfSelectionRelationValue() {
		return childOfSelection;
	}

	public org.instantlogic.designer.SelectionDesign getChildOfSelection() {
		return childOfSelection.getValue();
	}

    public ElementDesign setChildOfSelection(org.instantlogic.designer.SelectionDesign newValue) {
        childOfSelection.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, PropertyDesign> childrenForFragment
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, PropertyDesign> getChildrenForFragmentRelationValue() {
		return childrenForFragment;
	}

	public org.instantlogic.designer.PropertyDesign getChildrenForFragment() {
		return childrenForFragment.getValue();
	}

    public ElementDesign setChildrenForFragment(org.instantlogic.designer.PropertyDesign newValue) {
        childrenForFragment.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, PlaceTemplateDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, PlaceTemplateDesign> getContentOfPageRelationValue() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getContentOfPage() {
		return contentOfPage.getValue();
	}

    public ElementDesign setContentOfPage(org.instantlogic.designer.PlaceTemplateDesign newValue) {
        contentOfPage.setValue(newValue);
        return (ElementDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<ElementDesign, SharedFragmentTemplateDefinitionDesign> sharedTemplateDefinition
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.sharedTemplateDefinition);

	public org.instantlogic.fabric.value.RelationValue<ElementDesign, SharedFragmentTemplateDefinitionDesign> getSharedTemplateDefinitionRelationValue() {
		return sharedTemplateDefinition;
	}

	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign getSharedTemplateDefinition() {
		return sharedTemplateDefinition.getValue();
	}

    public ElementDesign setSharedTemplateDefinition(org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign newValue) {
        sharedTemplateDefinition.setValue(newValue);
        return (ElementDesign)this;
    }


}
