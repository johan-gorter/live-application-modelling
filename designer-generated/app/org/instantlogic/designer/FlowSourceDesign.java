package org.instantlogic.designer;


public  class FlowSourceDesign extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FlowSourceDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, EventDesign> startEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowSourceDesignEntity.startEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, EventDesign> getStartEventRelation() {
		return startEvent;
	}

	public org.instantlogic.designer.EventDesign getStartEvent() {
		return startEvent.get();
	}
	
	public void setStartEvent(org.instantlogic.designer.EventDesign newValue) {
		startEvent.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(org.instantlogic.designer.entity.FlowSourceDesignEntity.endNode);
		
	public org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, FlowNodeBaseDesign> getEndNodeRelation() {
		return endNode;
	}

	public org.instantlogic.designer.FlowNodeBaseDesign getEndNode() {
		return endNode.get();
	}
	
	public void setEndNode(org.instantlogic.designer.FlowNodeBaseDesign newValue) {
		endNode.setValue(newValue);
	}
	
	private final org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, EventDesign> endEvent
		= createRelationValue(org.instantlogic.designer.entity.FlowSourceDesignEntity.endEvent);
		
	public org.instantlogic.fabric.value.RelationValue<FlowSourceDesign, EventDesign> getEndEventRelation() {
		return endEvent;
	}

	public org.instantlogic.designer.EventDesign getEndEvent() {
		return endEvent.get();
	}
	
	public void setEndEvent(org.instantlogic.designer.EventDesign newValue) {
		endEvent.setValue(newValue);
	}

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowSourceDesign, FlowDesign> owner
		= createReverseRelationValue(org.instantlogic.designer.entity.FlowSourceDesignEntity.owner);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FlowSourceDesign, FlowDesign> getOwnerRelation() {
		return owner;
	}

	public org.instantlogic.designer.FlowDesign getOwner() {
		return owner.get();
	}


}
