package org.instantlogic.designer;


public class WidgetTemplateDesign extends FragmentTemplateDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.WidgetTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.String> widgetTypeName
		= createAttributeValue(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.widgetTypeName);
	
	public java.lang.String getWidgetTypeName() {
		return widgetTypeName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<WidgetTemplateDesign, java.lang.String> getWidgetTypeNameAttributeValue() {
		return widgetTypeName;
	}

	public WidgetTemplateDesign setWidgetTypeName(java.lang.String newValue) {
		widgetTypeName.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public WidgetTemplateDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	
	public WidgetTemplateDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, EventDesign> event
		= createRelationValue(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.event);
		
	public org.instantlogic.fabric.value.RelationValue<WidgetTemplateDesign, EventDesign> getEventRelationValue() {
		return event;
	}

	public org.instantlogic.designer.EventDesign getEvent() {
		return event.getValue();
	}
	
	public WidgetTemplateDesign setEvent(org.instantlogic.designer.EventDesign newValue) {
		event.setValue(newValue);
		return (WidgetTemplateDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetValue> values
		= createRelationValues(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.values);
		
	public org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetValue> getValuesRelationValue() {
		return values;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetValue> getValues() {
		return values.getValue();
	}
	
	public WidgetTemplateDesign addToValues(WidgetValue item) {
		values.addValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign addToValues(WidgetValue item, int index) {
		values.insertValue(item, index);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromValues(WidgetValue item) {
		values.removeValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromValues(int index) {
		values.removeValue(index);
		return (WidgetTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetText> texts
		= createRelationValues(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.texts);
		
	public org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetText> getTextsRelationValue() {
		return texts;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetText> getTexts() {
		return texts.getValue();
	}
	
	public WidgetTemplateDesign addToTexts(WidgetText item) {
		texts.addValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign addToTexts(WidgetText item, int index) {
		texts.insertValue(item, index);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromTexts(WidgetText item) {
		texts.removeValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromTexts(int index) {
		texts.removeValue(index);
		return (WidgetTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetChildList> childLists
		= createRelationValues(org.instantlogic.designer.entity.WidgetTemplateDesignEntity.childLists);
		
	public org.instantlogic.fabric.value.RelationValues<WidgetTemplateDesign, WidgetChildList> getChildListsRelationValue() {
		return childLists;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetChildList> getChildLists() {
		return childLists.getValue();
	}
	
	public WidgetTemplateDesign addToChildLists(WidgetChildList item) {
		childLists.addValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign addToChildLists(WidgetChildList item, int index) {
		childLists.insertValue(item, index);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromChildLists(WidgetChildList item) {
		childLists.removeValue(item);
		return (WidgetTemplateDesign)this;
	}
	
	public WidgetTemplateDesign removeFromChildLists(int index) {
		childLists.removeValue(index);
		return (WidgetTemplateDesign)this;
	}
	

	// Reverse relations

}
