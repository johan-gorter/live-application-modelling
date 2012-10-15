package org.instantlogic.designer;


public abstract class AbstractApplicationDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> getIsCustomizedAttributeValue() {
		return isCustomized;
	}

	public ApplicationDesign setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getNameAttributeValue() {
		return name;
	}

	public ApplicationDesign setName(java.lang.String newValue) {
		name.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> rootPackageName
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.rootPackageName);
	
	public java.lang.String getRootPackageName() {
		return rootPackageName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getRootPackageNameAttributeValue() {
		return rootPackageName;
	}

	public ApplicationDesign setRootPackageName(java.lang.String newValue) {
		rootPackageName.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> sourcePath
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.sourcePath);
	
	public java.lang.String getSourcePath() {
		return sourcePath.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getSourcePathAttributeValue() {
		return sourcePath;
	}

	public ApplicationDesign setSourcePath(java.lang.String newValue) {
		sourcePath.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> caseEntity
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> getCaseEntityRelationValue() {
		return caseEntity;
	}

	public org.instantlogic.designer.EntityDesign getCaseEntity() {
		return caseEntity.getValue();
	}
	
	public ApplicationDesign setCaseEntity(org.instantlogic.designer.EntityDesign newValue) {
		caseEntity.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	public org.instantlogic.designer.EntityDesign newCaseEntity() {
		org.instantlogic.designer.EntityDesign newValue = new org.instantlogic.designer.EntityDesign(); 
		caseEntity.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> getEntitiesRelationValue() {
		return entities;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getEntities() {
		return entities.getValue();
	}
	
	public ApplicationDesign addToEntities(EntityDesign item) {
		entities.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToEntities(EntityDesign item, int index) {
		entities.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEntities(EntityDesign item) {
		entities.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEntities(int index) {
		entities.removeValue(index);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> getEventsRelationValue() {
		return events;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign> getEvents() {
		return events.getValue();
	}
	
	public ApplicationDesign addToEvents(EventDesign item) {
		events.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToEvents(EventDesign item, int index) {
		events.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEvents(EventDesign item) {
		events.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEvents(int index) {
		events.removeValue(index);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> flows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.flows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getFlowsRelationValue() {
		return flows;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getFlows() {
		return flows.getValue();
	}
	
	public ApplicationDesign addToFlows(FlowDesign item) {
		flows.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToFlows(FlowDesign item, int index) {
		flows.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromFlows(FlowDesign item) {
		flows.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromFlows(int index) {
		flows.removeValue(index);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, FlowDesign> mainFlow
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.mainFlow);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, FlowDesign> getMainFlowRelationValue() {
		return mainFlow;
	}

	public org.instantlogic.designer.FlowDesign getMainFlow() {
		return mainFlow.getValue();
	}
	
	public ApplicationDesign setMainFlow(org.instantlogic.designer.FlowDesign newValue) {
		mainFlow.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	public org.instantlogic.designer.FlowDesign newMainFlow() {
		org.instantlogic.designer.FlowDesign newValue = new org.instantlogic.designer.FlowDesign(); 
		mainFlow.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, SharedElementDefinitionDesign> sharedElements
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedElements);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, SharedElementDefinitionDesign> getSharedElementsRelationValue() {
		return sharedElements;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDefinitionDesign> getSharedElements() {
		return sharedElements.getValue();
	}
	
	public ApplicationDesign addToSharedElements(SharedElementDefinitionDesign item) {
		sharedElements.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToSharedElements(SharedElementDefinitionDesign item, int index) {
		sharedElements.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromSharedElements(SharedElementDefinitionDesign item) {
		sharedElements.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromSharedElements(int index) {
		sharedElements.removeValue(index);
		return (ApplicationDesign)this;
	}
	

	// Reverse relations

}
