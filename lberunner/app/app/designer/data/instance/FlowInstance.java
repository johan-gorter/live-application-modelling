package app.designer.data.instance;

import java.util.List;

import app.designer.*;
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
		this(caseInstance, 0);
	}
	
	public FlowInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowEntity.INSTANCE, id);
	}
	
	protected FlowInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
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
