package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.FlowSourceDesignEntity;

public class FlowSourceDesign 
	extends SimpleInstance 
	implements Instance {

	public FlowSourceDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowSourceDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowSourceDesignEntity.INSTANCE, id);
	}
	
	protected FlowSourceDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FlowSourceDesign, EventDesign> startEvent
		= createRelationValue(FlowSourceDesignEntity.startEvent);
		
	public EventDesign getStartEvent() {
		return startEvent.get();
	}
	
	public void setStartEvent(EventDesign newValue) {
		startEvent.set(newValue);
	}
	
	public final RelationValue<FlowSourceDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(FlowSourceDesignEntity.endNode);
		
	public FlowNodeBaseDesign getEndNode() {
		return endNode.get();
	}
	
	public void setEndNode(FlowNodeBaseDesign newValue) {
		endNode.set(newValue);
	}
	
	public final RelationValue<FlowSourceDesign, EventDesign> endEvent
		= createRelationValue(FlowSourceDesignEntity.endEvent);
		
	public EventDesign getEndEvent() {
		return endEvent.get();
	}
	
	public void setEndEvent(EventDesign newValue) {
		endEvent.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowSourceDesign, FlowDesign> owner
		= createReverseRelationValue(FlowSourceDesignEntity.owner);

	public FlowDesign getOwner() {
		return owner.get();
	}


}
