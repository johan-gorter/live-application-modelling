package org.instantlogic.designer;


public abstract class AbstractApplicationDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getNameAttribute() {
		return name;
	}


	public void setName(java.lang.String newValue) {
		name.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> _package
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity._package);
	
	public java.lang.String get_package() {
		return _package.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> get_packageAttribute() {
		return _package;
	}


	public void set_package(java.lang.String newValue) {
		_package.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> sourcePath
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.sourcePath);
	
	public java.lang.String getSourcePath() {
		return sourcePath.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getSourcePathAttribute() {
		return sourcePath;
	}


	public void setSourcePath(java.lang.String newValue) {
		sourcePath.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> customization
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getCustomizationAttribute() {
		return customization;
	}


	public void setCustomization(java.lang.String newValue) {
		customization.setValue(newValue);
	}
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> getEntitiesRelation() {
		return entities;
	}

	public java.util.List<org.instantlogic.designer.EntityDesign> getEntities() {
		return entities.get();
	}
	
	public void setEntities(java.util.List<org.instantlogic.designer.EntityDesign> newValue) {
		entities.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> caseEntity
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> getCaseEntityRelation() {
		return caseEntity;
	}

	public org.instantlogic.designer.EntityDesign getCaseEntity() {
		return caseEntity.get();
	}
	
	public void setCaseEntity(org.instantlogic.designer.EntityDesign newValue) {
		caseEntity.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> flows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.flows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getFlowsRelation() {
		return flows;
	}

	public java.util.List<org.instantlogic.designer.FlowDesign> getFlows() {
		return flows.get();
	}
	
	public void setFlows(java.util.List<org.instantlogic.designer.FlowDesign> newValue) {
		flows.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> getEventsRelation() {
		return events;
	}

	public java.util.List<org.instantlogic.designer.EventDesign> getEvents() {
		return events.get();
	}
	
	public void setEvents(java.util.List<org.instantlogic.designer.EventDesign> newValue) {
		events.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> exposedFlows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.exposedFlows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getExposedFlowsRelation() {
		return exposedFlows;
	}

	public java.util.List<org.instantlogic.designer.FlowDesign> getExposedFlows() {
		return exposedFlows.get();
	}
	
	public void setExposedFlows(java.util.List<org.instantlogic.designer.FlowDesign> newValue) {
		exposedFlows.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> sharedPageFragments
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedPageFragments);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> getSharedPageFragmentsRelation() {
		return sharedPageFragments;
	}

	public java.util.List<org.instantlogic.designer.PageFragmentHolderDesign> getSharedPageFragments() {
		return sharedPageFragments.get();
	}
	
	public void setSharedPageFragments(java.util.List<org.instantlogic.designer.PageFragmentHolderDesign> newValue) {
		sharedPageFragments.setValue(newValue);
	}

	// Reverse relations

}
