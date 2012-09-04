package org.instantlogic.designer;


public class FlowNodeBaseDesign extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> incomingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.incomingEdges);

	public org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getIncomingEdgesRelationValue() {
		return incomingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getIncomingEdges() {
		return incomingEdges.getValue();
	}

    public FlowNodeBaseDesign addToIncomingEdges(FlowEdgeDesign item) {
        incomingEdges.addValue(item);
        return (FlowNodeBaseDesign)this;
    }

    public FlowNodeBaseDesign removeFromIncomingEdges(FlowEdgeDesign item) {
        incomingEdges.removeValue(item);
        return (FlowNodeBaseDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> outgoingEdges
		= createReverseRelationValues(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.outgoingEdges);

	public org.instantlogic.fabric.value.RelationValues<FlowNodeBaseDesign, FlowEdgeDesign> getOutgoingEdgesRelationValue() {
		return outgoingEdges;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowEdgeDesign> getOutgoingEdges() {
		return outgoingEdges.getValue();
	}

    public FlowNodeBaseDesign addToOutgoingEdges(FlowEdgeDesign item) {
        outgoingEdges.addValue(item);
        return (FlowNodeBaseDesign)this;
    }

    public FlowNodeBaseDesign removeFromOutgoingEdges(FlowEdgeDesign item) {
        outgoingEdges.removeValue(item);
        return (FlowNodeBaseDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<FlowNodeBaseDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.owner);

	public org.instantlogic.fabric.value.RelationValue<FlowNodeBaseDesign, FlowDesign> getOwnerRelationValue() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.getValue();
	}

    public FlowNodeBaseDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
        owner.setValue(newValue);
        return (FlowNodeBaseDesign)this;
    }


}
