package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ApplicationDesign 
	extends SimpleCaseInstance 
	implements Instance {

	public ApplicationDesign() {
		super(ApplicationDesignEntity.INSTANCE, DesignerApplication.INSTANCE);
	}

	// Attributes
	
	public final AttributeValue<ApplicationDesign, java.lang.String> name
		= createAttributeValue(ApplicationDesignEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	public void setName(java.lang.String newValue) {
		name.set(newValue);
	}
	
	public final AttributeValue<ApplicationDesign, java.lang.String> customization
		= createAttributeValue(ApplicationDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	public void setCustomization(java.lang.String newValue) {
		customization.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(ApplicationDesignEntity.entities);
		
	public List<EntityDesign> getEntities() {
		return entities.get();
	}
	
	public void setEntities(List<EntityDesign> newValue) {
		entities.set(newValue);
	}
	
	public final RelationValue<ApplicationDesign, EntityDesign> caseEntity
		= createRelationValue(ApplicationDesignEntity.caseEntity);
		
	public EntityDesign getCaseEntity() {
		return caseEntity.get();
	}
	
	public void setCaseEntity(EntityDesign newValue) {
		caseEntity.set(newValue);
	}
	
	public final RelationValues<ApplicationDesign, FlowDesign> flows
		= createRelationValues(ApplicationDesignEntity.flows);
		
	public List<FlowDesign> getFlows() {
		return flows.get();
	}
	
	public void setFlows(List<FlowDesign> newValue) {
		flows.set(newValue);
	}
	
	public final RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(ApplicationDesignEntity.events);
		
	public List<EventDesign> getEvents() {
		return events.get();
	}
	
	public void setEvents(List<EventDesign> newValue) {
		events.set(newValue);
	}
	
	public final RelationValues<ApplicationDesign, FlowDesign> exposedFlows
		= createRelationValues(ApplicationDesignEntity.exposedFlows);
		
	public List<FlowDesign> getExposedFlows() {
		return exposedFlows.get();
	}
	
	public void setExposedFlows(List<FlowDesign> newValue) {
		exposedFlows.set(newValue);
	}
	
	public final RelationValues<ApplicationDesign, PageFragmentHolderDesign> sharedPageFragments
		= createRelationValues(ApplicationDesignEntity.sharedPageFragments);
		
	public List<PageFragmentHolderDesign> getSharedPageFragments() {
		return sharedPageFragments.get();
	}
	
	public void setSharedPageFragments(List<PageFragmentHolderDesign> newValue) {
		sharedPageFragments.set(newValue);
	}

	// Reverse relations

}
