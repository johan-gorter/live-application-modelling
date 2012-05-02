package org.instantlogic.designer;


public class FragmentTemplateDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, SharedFragmentTemplateDefinitionDesign> sharedTemplateDefinition
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.sharedTemplateDefinition);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, SharedFragmentTemplateDefinitionDesign> getSharedTemplateDefinitionRelationValue() {
		return sharedTemplateDefinition;
	}

	public org.instantlogic.designer.SharedFragmentTemplateDefinitionDesign getSharedTemplateDefinition() {
		return sharedTemplateDefinition.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PlaceTemplateDesign> contentOfPage
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.contentOfPage);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, PlaceTemplateDesign> getContentOfPageRelationValue() {
		return contentOfPage;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getContentOfPage() {
		return contentOfPage.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, CompositeTemplateDesign> childOf
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childOf);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, CompositeTemplateDesign> getChildOfRelationValue() {
		return childOf;
	}

	public org.instantlogic.designer.CompositeTemplateDesign getChildOf() {
		return childOf.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, WidgetChildList> childrenForWidget
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childrenForWidget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, WidgetChildList> getChildrenForWidgetRelationValue() {
		return childrenForWidget;
	}

	public org.instantlogic.designer.WidgetChildList getChildrenForWidget() {
		return childrenForWidget.getValue();
	}


}
