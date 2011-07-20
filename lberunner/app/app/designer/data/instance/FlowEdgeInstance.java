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

public class FlowEdgeInstance 
	extends SimpleInstance 
	implements Instance {

	public FlowEdgeInstance(CaseInstance caseInstance) {
		super(caseInstance, FlowEdgeEntity.INSTANCE, 0);
	}
	
	protected FlowEdgeInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model, 0);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FlowEdgeInstance, FlowNodeBaseInstance> from
		= createRelationValue(FlowEdgeEntity.from);
	
	public final RelationValue<FlowEdgeInstance, FlowNodeBaseInstance> to
		= createRelationValue(FlowEdgeEntity.to);

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowEdgeInstance, FlowInstance> flow
		= createReverseRelationValue(FlowEdgeEntity.flow);

}
