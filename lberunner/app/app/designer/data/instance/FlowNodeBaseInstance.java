package app.designer.data.instance;

import java.util.List;

import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowNodeBaseInstance 
	extends ConceptInstance 
	implements Instance {

	public FlowNodeBaseInstance(CaseInstance caseInstance) {
		super(caseInstance, FlowNodeBaseEntity.INSTANCE);
	}
	
	protected FlowNodeBaseInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowNodeBaseInstance, FlowInstance> flow
		= createReverseRelationValue(FlowNodeBaseEntity.flow);
	
	public final ReadOnlyRelationValues<FlowNodeBaseInstance, FlowEdgeInstance> outgoingEdges
		= createReverseRelationValues(FlowNodeBaseEntity.outgoingEdges);
	
	public final ReadOnlyRelationValues<FlowNodeBaseInstance, FlowEdgeInstance> incomingEdges
		= createReverseRelationValues(FlowNodeBaseEntity.incomingEdges);

}