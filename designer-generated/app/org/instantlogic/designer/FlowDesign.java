package org.instantlogic.designer;


public  class FlowDesign extends Design { 

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

	public java.util.List<org.instantlogic.designer.FlowSourceDesign> getSources() {
		return sources.get();
	}
	
	public void setSources(java.util.List<org.instantlogic.designer.FlowSourceDesign> newValue) {
		sources.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.nodes);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowNodeBaseDesign> getNodesRelation() {
		return nodes;
	}

	public java.util.List<org.instantlogic.designer.FlowNodeBaseDesign> getNodes() {
		return nodes.get();
	}
	
	public void setNodes(java.util.List<org.instantlogic.designer.FlowNodeBaseDesign> newValue) {
		nodes.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.edges);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, FlowEdgeDesign> getEdgesRelation() {
		return edges;
	}

	public java.util.List<org.instantlogic.designer.FlowEdgeDesign> getEdges() {
		return edges.get();
	}
	
	public void setEdges(java.util.List<org.instantlogic.designer.FlowEdgeDesign> newValue) {
		edges.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<FlowDesign, EntityDesign> getParametersRelation() {
		return parameters;
	}

	public java.util.List<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.get();
	}
	
	public void setParameters(java.util.List<org.instantlogic.designer.EntityDesign> newValue) {
		parameters.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.application);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getApplicationRelation() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> exposedFlowInApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.exposedFlowInApplication);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, ApplicationDesign> getExposedFlowInApplicationRelation() {
		return exposedFlowInApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getExposedFlowInApplication() {
		return exposedFlowInApplication.get();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowDesignEntity.subFlowIn);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowDesign, SubFlowDesign> getSubFlowInRelation() {
		return subFlowIn;
	}

	public org.instantlogic.designer.SubFlowDesign getSubFlowIn() {
		return subFlowIn.get();
	}


}
