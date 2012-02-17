package app.designer;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;

import app.designer.entity.FlowNodeBaseDesignEntity;

public class FlowNodeBaseDesign 
	extends Design 
	implements Instance {

	public FlowNodeBaseDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowNodeBaseDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowNodeBaseDesignEntity.INSTANCE, id);
	}
	
	protected FlowNodeBaseDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowNodeBaseDesign, FlowDesign> owner
		= createReverseRelationValue(FlowNodeBaseDesignEntity.owner);

	public FlowDesign getOwner() {
		return owner.get();
	}

	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowSourceDesign> incomingSources
		= createReverseRelationValues(FlowNodeBaseDesignEntity.incomingSources);

	public List<FlowSourceDesign> getIncomingSources() {
		return incomingSources.get();
	}

	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> outgoingEdges
		= createReverseRelationValues(FlowNodeBaseDesignEntity.outgoingEdges);

	public List<FlowEdgeDesign> getOutgoingEdges() {
		return outgoingEdges.get();
	}

	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> incomingEdges
		= createReverseRelationValues(FlowNodeBaseDesignEntity.incomingEdges);

	public List<FlowEdgeDesign> getIncomingEdges() {
		return incomingEdges.get();
	}


}
