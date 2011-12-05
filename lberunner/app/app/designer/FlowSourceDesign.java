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
	
	public final RelationValue<FlowSourceDesign, FlowNodeBaseDesign> endNode
		= createRelationValue(FlowSourceDesignEntity.endNode);
	
	public final RelationValue<FlowSourceDesign, EventDesign> endEvent
		= createRelationValue(FlowSourceDesignEntity.endEvent);

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowSourceDesign, FlowDesign> owner
		= createReverseRelationValue(FlowSourceDesignEntity.owner);

}
