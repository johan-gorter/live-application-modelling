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

public class SubFlowInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public SubFlowInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SubFlowInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, SubFlowEntity.INSTANCE, id);
	}
	
	protected SubFlowInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SubFlowInstance, FlowInstance> flow
		= createRelationValue(SubFlowEntity.flow);

	// Reverse relations

}
