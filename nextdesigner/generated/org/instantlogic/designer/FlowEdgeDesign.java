package org.instantlogic.designer;


public class FlowEdgeDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> startNode
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.startNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getStartNodeRelationValue() {
		return startNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getStartNode() {
		return startNode.getValue();
	}
	
	public FlowEdgeDesign setStartNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		startNode.setValue(newValue);
		return (FlowEdgeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> startEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.startEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> getStartEventRelationValue() {
		return startEvent;
	}

	public org.instantlogic.designer.EventDesign getStartEvent() {
		return startEvent.getValue();
	}
	
	public FlowEdgeDesign setStartEvent(org.instantlogic.designer.EventDesign newValue) {
		startEvent.setValue(newValue);
		return (FlowEdgeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getEndNodeRelationValue() {
		return endNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getEndNode() {
		return endNode.getValue();
	}
	
	public FlowEdgeDesign setEndNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		endNode.setValue(newValue);
		return (FlowEdgeDesign)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> endEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> getEndEventRelationValue() {
		return endEvent;
	}

	public org.instantlogic.designer.EventDesign getEndEvent() {
		return endEvent.getValue();
	}
	
	public FlowEdgeDesign setEndEvent(org.instantlogic.designer.EventDesign newValue) {
		endEvent.setValue(newValue);
		return (FlowEdgeDesign)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.owner);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> getOwnerRelationValue() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.getValue();
	}


}
