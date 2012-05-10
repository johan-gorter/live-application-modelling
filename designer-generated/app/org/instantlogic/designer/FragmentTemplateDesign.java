package org.instantlogic.designer;


public class FragmentTemplateDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> fragmentTypeName
		= createAttributeValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentTypeName);
	
	public java.lang.String getFragmentTypeName() {
		return fragmentTypeName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> getFragmentTypeNameAttributeValue() {
		return fragmentTypeName;
	}

	public FragmentTemplateDesign setFragmentTypeName(java.lang.String newValue) {
		fragmentTypeName.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, DeductionSchemeDesign> selections
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.selections);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, DeductionSchemeDesign> getSelectionsRelationValue() {
		return selections;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionSchemeDesign> getSelections() {
		return selections.getValue();
	}
	
	public FragmentTemplateDesign addToSelections(DeductionSchemeDesign item) {
		selections.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToSelections(DeductionSchemeDesign item, int index) {
		selections.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromSelections(DeductionSchemeDesign item) {
		selections.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromSelections(int index) {
		selections.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public FragmentTemplateDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	
	public FragmentTemplateDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EventDesign> event
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.event);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EventDesign> getEventRelationValue() {
		return event;
	}

	public org.instantlogic.designer.EventDesign getEvent() {
		return event.getValue();
	}
	
	public FragmentTemplateDesign setEvent(org.instantlogic.designer.EventDesign newValue) {
		event.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentValue> values
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.values);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentValue> getValuesRelationValue() {
		return values;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentValue> getValues() {
		return values.getValue();
	}
	
	public FragmentTemplateDesign addToValues(FragmentValue item) {
		values.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToValues(FragmentValue item, int index) {
		values.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromValues(FragmentValue item) {
		values.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromValues(int index) {
		values.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentText> texts
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.texts);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentText> getTextsRelationValue() {
		return texts;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentText> getTexts() {
		return texts.getValue();
	}
	
	public FragmentTemplateDesign addToTexts(FragmentText item) {
		texts.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToTexts(FragmentText item, int index) {
		texts.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromTexts(FragmentText item) {
		texts.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromTexts(int index) {
		texts.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentChildList> childLists
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childLists);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, FragmentChildList> getChildListsRelationValue() {
		return childLists;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentChildList> getChildLists() {
		return childLists.getValue();
	}
	
	public FragmentTemplateDesign addToChildLists(FragmentChildList item) {
		childLists.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToChildLists(FragmentChildList item, int index) {
		childLists.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromChildLists(FragmentChildList item) {
		childLists.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromChildLists(int index) {
		childLists.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	

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

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, FragmentChildList> childrenForFragment
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.childrenForFragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentTemplateDesign, FragmentChildList> getChildrenForFragmentRelationValue() {
		return childrenForFragment;
	}

	public org.instantlogic.designer.FragmentChildList getChildrenForFragment() {
		return childrenForFragment.getValue();
	}


}
