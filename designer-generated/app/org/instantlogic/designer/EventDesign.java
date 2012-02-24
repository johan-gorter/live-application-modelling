package org.instantlogic.designer;


public class EventDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> getParametersRelation() {
		return parameters;
	}

	public java.util.List<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.get();
	}
	
	public void setParameters(java.util.List<org.instantlogic.designer.EntityDesign> newValue) {
		parameters.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EventDesign, ApplicationDesign> getApplicationRelation() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, LinkDesign> firesFromButtons
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.firesFromButtons);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, LinkDesign> getFiresFromButtonsRelation() {
		return firesFromButtons;
	}

	public java.util.List<org.instantlogic.designer.LinkDesign> getFiresFromButtons() {
		return firesFromButtons.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> startEventInSources
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.startEventInSources);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> getStartEventInSourcesRelation() {
		return startEventInSources;
	}

	public java.util.List<org.instantlogic.designer.FlowSourceDesign> getStartEventInSources() {
		return startEventInSources.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> endEventInSources
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.endEventInSources);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> getEndEventInSourcesRelation() {
		return endEventInSources;
	}

	public java.util.List<org.instantlogic.designer.FlowSourceDesign> getEndEventInSources() {
		return endEventInSources.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> startEventInEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.startEventInEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> getStartEventInEdgesRelation() {
		return startEventInEdges;
	}

	public java.util.List<org.instantlogic.designer.FlowEdgeDesign> getStartEventInEdges() {
		return startEventInEdges.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> endEventInEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.endEventInEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> getEndEventInEdgesRelation() {
		return endEventInEdges;
	}

	public java.util.List<org.instantlogic.designer.FlowEdgeDesign> getEndEventInEdges() {
		return endEventInEdges.get();
	}


}
