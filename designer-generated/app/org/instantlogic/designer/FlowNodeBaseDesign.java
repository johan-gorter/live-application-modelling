package org.instantlogic.designer;


public class FlowNodeBaseDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> incomingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getIncomingEdgesRelationValue() {
		return incomingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getIncomingEdges() {
		return incomingEdges.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowSourceDesign> incomingSources
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingSources);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowSourceDesign> getIncomingSourcesRelationValue() {
		return incomingSources;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowSourceDesign> getIncomingSources() {
		return incomingSources.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> outgoingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.outgoingEdges);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getOutgoingEdgesRelationValue() {
		return outgoingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getOutgoingEdges() {
		return outgoingEdges.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowNodeBaseDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.owner);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowNodeBaseDesign, FlowDesign> getOwnerRelationValue() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.getValue();
	}


}
