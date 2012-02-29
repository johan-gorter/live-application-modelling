package org.instantlogic.designer;


public class FlowDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowSourceDesign> sources
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.sources);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowSourceDesign> getSourcesRelation() {
		return sources;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign> getSources() {
		return sources.getValue();
	}
	
	public void addToSources(FlowSourceDesign item) {
		sources.addValue(item);
	}
	
	public void addToSources(FlowSourceDesign item, int index) {
		sources.insertValue(item, index);
	}
	
	public void removeFromSources(FlowSourceDesign item) {
		sources.removeValue(item);
	}
	
	public void removeFromSources(int index) {
		sources.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> getNodesRelation() {
		return nodes;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign> getNodes() {
		return nodes.getValue();
	}
	
	public void addToNodes(FlowNodeBaseDesign item) {
		nodes.addValue(item);
	}
	
	public void addToNodes(FlowNodeBaseDesign item, int index) {
		nodes.insertValue(item, index);
	}
	
	public void removeFromNodes(FlowNodeBaseDesign item) {
		nodes.removeValue(item);
	}
	
	public void removeFromNodes(int index) {
		nodes.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.edges);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> getEdgesRelation() {
		return edges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getEdges() {
		return edges.getValue();
	}
	
	public void addToEdges(FlowEdgeDesign item) {
		edges.addValue(item);
	}
	
	public void addToEdges(FlowEdgeDesign item, int index) {
		edges.insertValue(item, index);
	}
	
	public void removeFromEdges(FlowEdgeDesign item) {
		edges.removeValue(item);
	}
	
	public void removeFromEdges(int index) {
		edges.removeValue(index);
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> getParametersRelation() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public void addToParameters(EntityDesign item) {
		parameters.addValue(item);
	}
	
	public void addToParameters(EntityDesign item, int index) {
		parameters.insertValue(item, index);
	}
	
	public void removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
	}
	
	public void removeFromParameters(int index) {
		parameters.removeValue(index);
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getApplicationRelation() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> exposedFlowInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.exposedFlowInApplication);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getExposedFlowInApplicationRelation() {
		return exposedFlowInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getExposedFlowInApplication() {
		return exposedFlowInApplication.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.subFlowIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> getSubFlowInRelation() {
		return subFlowIn;
	}

	public org.instantlogic.designer.SubFlowDesign getSubFlowIn() {
		return subFlowIn.getValue();
	}


}
