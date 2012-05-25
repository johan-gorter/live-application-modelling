package org.instantlogic.designer;


public class FlowDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.edges);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> getEdgesRelationValue() {
		return edges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getEdges() {
		return edges.getValue();
	}
	
	public FlowDesign addToEdges(FlowEdgeDesign item) {
		edges.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign addToEdges(FlowEdgeDesign item, int index) {
		edges.insertValue(item, index);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromEdges(FlowEdgeDesign item) {
		edges.removeValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromEdges(int index) {
		edges.removeValue(index);
		return (FlowDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> getNodesRelationValue() {
		return nodes;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign> getNodes() {
		return nodes.getValue();
	}
	
	public FlowDesign addToNodes(FlowNodeBaseDesign item) {
		nodes.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign addToNodes(FlowNodeBaseDesign item, int index) {
		nodes.insertValue(item, index);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromNodes(FlowNodeBaseDesign item) {
		nodes.removeValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromNodes(int index) {
		nodes.removeValue(index);
		return (FlowDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public FlowDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign addToParameters(EntityDesign item, int index) {
		parameters.insertValue(item, index);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (FlowDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowSourceDesign> sources
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.sources);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowSourceDesign> getSourcesRelationValue() {
		return sources;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign> getSources() {
		return sources.getValue();
	}
	
	public FlowDesign addToSources(FlowSourceDesign item) {
		sources.addValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign addToSources(FlowSourceDesign item, int index) {
		sources.insertValue(item, index);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromSources(FlowSourceDesign item) {
		sources.removeValue(item);
		return (FlowDesign)this;
	}
	
	public FlowDesign removeFromSources(int index) {
		sources.removeValue(index);
		return (FlowDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> exposedFlowInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.exposedFlowInApplication);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getExposedFlowInApplicationRelationValue() {
		return exposedFlowInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getExposedFlowInApplication() {
		return exposedFlowInApplication.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.subFlowIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> getSubFlowInRelationValue() {
		return subFlowIn;
	}

	public org.instantlogic.designer.SubFlowDesign getSubFlowIn() {
		return subFlowIn.getValue();
	}


}
