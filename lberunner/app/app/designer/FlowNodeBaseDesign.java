package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowNodeBaseDesign 
	extends Concept 
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
	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowSourceDesign> incomingSources
		= createReverseRelationValues(FlowNodeBaseDesignEntity.incomingSources);
	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> outgoingEdges
		= createReverseRelationValues(FlowNodeBaseDesignEntity.outgoingEdges);
	
	public final ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> incomingEdges
		= createReverseRelationValues(FlowNodeBaseDesignEntity.incomingEdges);

}
