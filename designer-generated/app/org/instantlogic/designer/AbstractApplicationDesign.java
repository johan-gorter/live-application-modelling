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
	
	
	// Relations
	
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
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> exposedFlows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.exposedFlows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getExposedFlowsRelationValue() {
		return exposedFlows;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getExposedFlows() {
		return exposedFlows.getValue();
	}
	
	public ApplicationDesign addToExposedFlows(FlowDesign item) {
		exposedFlows.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToExposedFlows(FlowDesign item, int index) {
		exposedFlows.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromExposedFlows(FlowDesign item) {
		exposedFlows.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromExposedFlows(int index) {
		exposedFlows.removeValue(index);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> sharedPageFragments
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedPageFragments);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> getSharedPageFragmentsRelationValue() {
		return sharedPageFragments;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageFragmentHolderDesign> getSharedPageFragments() {
		return sharedPageFragments.getValue();
	}
	
	public ApplicationDesign addToSharedPageFragments(PageFragmentHolderDesign item) {
		sharedPageFragments.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign addToSharedPageFragments(PageFragmentHolderDesign item, int index) {
		sharedPageFragments.insertValue(item, index);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromSharedPageFragments(PageFragmentHolderDesign item) {
		sharedPageFragments.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromSharedPageFragments(int index) {
		sharedPageFragments.removeValue(index);
		return (ApplicationDesign)this;
	}
	

	// Reverse relations

}
