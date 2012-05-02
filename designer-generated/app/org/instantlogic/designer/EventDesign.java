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
		
	public org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public EventDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign addToParameters(EntityDesign item, int index) {
		parameters.insertValue(item, index);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (EventDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<EventDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, WidgetTemplateDesign> triggeredByWidget
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.triggeredByWidget);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, WidgetTemplateDesign> getTriggeredByWidgetRelationValue() {
		return triggeredByWidget;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.WidgetTemplateDesign> getTriggeredByWidget() {
		return triggeredByWidget.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> startEventInSources
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.startEventInSources);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> getStartEventInSourcesRelationValue() {
		return startEventInSources;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign> getStartEventInSources() {
		return startEventInSources.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> endEventInSources
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.endEventInSources);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowSourceDesign> getEndEventInSourcesRelationValue() {
		return endEventInSources;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign> getEndEventInSources() {
		return endEventInSources.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> startEventInEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.startEventInEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> getStartEventInEdgesRelationValue() {
		return startEventInEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getStartEventInEdges() {
		return startEventInEdges.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> endEventInEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.endEventInEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> getEndEventInEdgesRelationValue() {
		return endEventInEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getEndEventInEdges() {
		return endEventInEdges.getValue();
	}


}
