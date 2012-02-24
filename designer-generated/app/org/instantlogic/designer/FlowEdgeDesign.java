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
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getStartNodeRelation() {
		return startNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getStartNode() {
		return startNode.get();
	}
	
	public void setStartNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		startNode.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> startEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.startEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> getStartEventRelation() {
		return startEvent;
	}

	public org.instantlogic.designer.EventDesign getStartEvent() {
		return startEvent.get();
	}
	
	public void setStartEvent(org.instantlogic.designer.EventDesign newValue) {
		startEvent.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> getEndNodeRelation() {
		return endNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getEndNode() {
		return endNode.get();
	}
	
	public void setEndNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		endNode.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> endEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.endEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowEdgeDesign, EventDesign> getEndEventRelation() {
		return endEvent;
	}

	public org.instantlogic.designer.EventDesign getEndEvent() {
		return endEvent.get();
	}
	
	public void setEndEvent(org.instantlogic.designer.EventDesign newValue) {
		endEvent.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowEdgeDesignEntity.owner);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> getOwnerRelation() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.get();
	}


}
