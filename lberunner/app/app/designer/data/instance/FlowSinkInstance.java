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

public class FlowSinkInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public FlowSinkInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowSinkInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowSinkEntity.INSTANCE, id);
	}
	
	protected FlowSinkInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowSinkInstance, FlowInstance> flow
		= createReverseRelationValue(FlowSinkEntity.flow);

}
