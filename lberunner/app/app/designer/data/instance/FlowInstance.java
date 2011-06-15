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

public class FlowInstance 
	extends ConceptInstance 
	implements Instance {

	public FlowInstance(CaseInstance caseInstance) {
		super(caseInstance, FlowEntity.INSTANCE);
	}
	
	protected FlowInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<FlowInstance, FlowSourceInstance> sources
		= createRelationValues(FlowEntity.sources);
	
	public final RelationValues<FlowInstance, FlowSinkInstance> sinks
		= createRelationValues(FlowEntity.sinks);
	
	public final RelationValues<FlowInstance, FlowNodeBaseInstance> nodes
		= createRelationValues(FlowEntity.nodes);
	
	public final RelationValues<FlowInstance, FlowEdgeInstance> edges
		= createRelationValues(FlowEntity.edges);

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowInstance, ApplicationInstance> application
		= createReverseRelationValue(FlowEntity.application);
	
	public final ReadOnlyRelationValue<FlowInstance, ApplicationInstance> exposedFlowInApplication
		= createReverseRelationValue(FlowEntity.exposedFlowInApplication);

}
