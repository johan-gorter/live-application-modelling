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

public class FlowEdgeInstance 
	extends SimpleInstance 
	implements Instance {

	public FlowEdgeInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowEdgeInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowEdgeEntity.INSTANCE, id);
	}
	
	protected FlowEdgeInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<FlowEdgeInstance, java.lang.String> entryName
		= createAttributeValue(FlowEdgeEntity.entryName);
	
	public final AttributeValue<FlowEdgeInstance, java.lang.String> exitName
		= createAttributeValue(FlowEdgeEntity.exitName);
	
	// Relations
	
	public final RelationValue<FlowEdgeInstance, FlowNodeBaseInstance> from
		= createRelationValue(FlowEdgeEntity.from);
	
	public final RelationValue<FlowEdgeInstance, FlowNodeBaseInstance> to
		= createRelationValue(FlowEdgeEntity.to);

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowEdgeInstance, FlowInstance> owner
		= createReverseRelationValue(FlowEdgeEntity.owner);

}
