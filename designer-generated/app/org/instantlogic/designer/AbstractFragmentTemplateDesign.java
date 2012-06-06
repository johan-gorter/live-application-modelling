package org.instantlogic.designer;


public abstract class AbstractFragmentTemplateDesign extends ElementDesign { 

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

	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, PropertyDesign> properties
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, PropertyDesign> getPropertiesRelationValue() {
		return properties;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign> getProperties() {
		return properties.getValue();
	}
	
	public FragmentTemplateDesign addToProperties(PropertyDesign item) {
		properties.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToProperties(PropertyDesign item, int index) {
		properties.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromProperties(PropertyDesign item) {
		properties.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromProperties(int index) {
		properties.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	

	// Reverse relations

}
