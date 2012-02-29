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
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> rootPackageName
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.rootPackageName);
	
	public java.lang.String getRootPackageName() {
		return rootPackageName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getRootPackageNameAttribute() {
		return rootPackageName;
	}

	public void setRootPackageName(java.lang.String newValue) {
		rootPackageName.setValue(newValue);
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
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> getIsCustomizedAttribute() {
		return isCustomized;
	}

	public void setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> getEntitiesRelation() {
		return entities;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getEntities() {
		return entities.get();
	}
	
	public void addToEntities(EntityDesign item) {
		entities.addValue(item);
	}
	
	public void addToEntities(EntityDesign item, int index) {
		entities.insertValue(item, index);
	}
	
	public void removeFromEntities(EntityDesign item) {
		entities.removeValue(item);
	}
	
	public void removeFromEntities(int index) {
		entities.removeValue(index);
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

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getFlows() {
		return flows.get();
	}
	
	public void addToFlows(FlowDesign item) {
		flows.addValue(item);
	}
	
	public void addToFlows(FlowDesign item, int index) {
		flows.insertValue(item, index);
	}
	
	public void removeFromFlows(FlowDesign item) {
		flows.removeValue(item);
	}
	
	public void removeFromFlows(int index) {
		flows.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> getEventsRelation() {
		return events;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign> getEvents() {
		return events.get();
	}
	
	public void addToEvents(EventDesign item) {
		events.addValue(item);
	}
	
	public void addToEvents(EventDesign item, int index) {
		events.insertValue(item, index);
	}
	
	public void removeFromEvents(EventDesign item) {
		events.removeValue(item);
	}
	
	public void removeFromEvents(int index) {
		events.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> exposedFlows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.exposedFlows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getExposedFlowsRelation() {
		return exposedFlows;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign> getExposedFlows() {
		return exposedFlows.get();
	}
	
	public void addToExposedFlows(FlowDesign item) {
		exposedFlows.addValue(item);
	}
	
	public void addToExposedFlows(FlowDesign item, int index) {
		exposedFlows.insertValue(item, index);
	}
	
	public void removeFromExposedFlows(FlowDesign item) {
		exposedFlows.removeValue(item);
	}
	
	public void removeFromExposedFlows(int index) {
		exposedFlows.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> sharedPageFragments
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedPageFragments);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, PageFragmentHolderDesign> getSharedPageFragmentsRelation() {
		return sharedPageFragments;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageFragmentHolderDesign> getSharedPageFragments() {
		return sharedPageFragments.get();
	}
	
	public void addToSharedPageFragments(PageFragmentHolderDesign item) {
		sharedPageFragments.addValue(item);
	}
	
	public void addToSharedPageFragments(PageFragmentHolderDesign item, int index) {
		sharedPageFragments.insertValue(item, index);
	}
	
	public void removeFromSharedPageFragments(PageFragmentHolderDesign item) {
		sharedPageFragments.removeValue(item);
	}
	
	public void removeFromSharedPageFragments(int index) {
		sharedPageFragments.removeValue(index);
	}
	

	// Reverse relations

}
