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

public class FlowSourceInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public FlowSourceInstance(CaseInstance caseInstance) {
		super(caseInstance, FlowSourceEntity.INSTANCE);
	}
	
	protected FlowSourceInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowSourceInstance, FlowInstance> flow
		= createReverseRelationValue(FlowSourceEntity.flow);

}
