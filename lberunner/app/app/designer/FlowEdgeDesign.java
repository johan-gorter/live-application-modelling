package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.FlowEdgeDesignEntity;

public class FlowEdgeDesign 
	extends SimpleInstance 
	implements Instance {

	public FlowEdgeDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowEdgeDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowEdgeDesignEntity.INSTANCE, id);
	}
	
	protected FlowEdgeDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> startNode
		= createRelationValue(FlowEdgeDesignEntity.startNode);
		
	public FlowNodeBaseDesign getStartNode() {
		return startNode.get();
	}
	
	public void setStartNode(FlowNodeBaseDesign newValue) {
		startNode.set(newValue);
	}
	
	public final RelationValue<FlowEdgeDesign, EventDesign> startEvent
		= createRelationValue(FlowEdgeDesignEntity.startEvent);
		
	public EventDesign getStartEvent() {
		return startEvent.get();
	}
	
	public void setStartEvent(EventDesign newValue) {
		startEvent.set(newValue);
	}
	
	public final RelationValue<FlowEdgeDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(FlowEdgeDesignEntity.endNode);
		
	public FlowNodeBaseDesign getEndNode() {
		return endNode.get();
	}
	
	public void setEndNode(FlowNodeBaseDesign newValue) {
		endNode.set(newValue);
	}
	
	public final RelationValue<FlowEdgeDesign, EventDesign> endEvent
		= createRelationValue(FlowEdgeDesignEntity.endEvent);
		
	public EventDesign getEndEvent() {
		return endEvent.get();
	}
	
	public void setEndEvent(EventDesign newValue) {
		endEvent.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowEdgeDesign, FlowDesign> owner
		= createReverseRelationValue(FlowEdgeDesignEntity.owner);

	public FlowDesign getOwner() {
		return owner.get();
	}


}
