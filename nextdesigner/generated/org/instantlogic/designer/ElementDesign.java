package org.instantlogic.designer;


public class ElementDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, PropertyDesign> childrenForFragment
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.childrenForFragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, PropertyDesign> getChildrenForFragmentRelationValue() {
		return childrenForFragment;
	}

	public org.instantlogic.designer.PropertyDesign getChildrenForFragment() {
		return childrenForFragment.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, PlaceTemplateDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, PlaceTemplateDesign> getContentOfPageRelationValue() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getContentOfPage() {
		return contentOfPage.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, SharedFragmentTemplateDefinitionDesign> sharedTemplateDefinition
		= createReverseRelationValue(org.instantlogic.designer.entity.ElementDesignEntity.sharedTemplateDefinition);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<ElementDesign, SharedFragmentTemplateDefinitionDesign> getSharedTemplateDefinitionRelationValue() {
		return sharedTemplateDefinition;
	}

	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign getSharedTemplateDefinition() {
		return sharedTemplateDefinition.getValue();
	}


}
