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

public class FlowDesign 
	extends Concept 
	implements Instance {

	public FlowDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowDesignEntity.INSTANCE, id);
	}
	
	protected FlowDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<FlowDesign, FlowSourceDesign> sources
		= createRelationValues(FlowDesignEntity.sources);
	
	public final RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(FlowDesignEntity.nodes);
	
	public final RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(FlowDesignEntity.edges);
	
	public final RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(FlowDesignEntity.parameters);

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(FlowDesignEntity.application);
	
	public final ReadOnlyRelationValue<FlowDesign, ApplicationDesign> exposedFlowInApplication
		= createReverseRelationValue(FlowDesignEntity.exposedFlowInApplication);
	
	public final ReadOnlyRelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(FlowDesignEntity.subFlowIn);

}
