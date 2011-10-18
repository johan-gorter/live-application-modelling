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

public class FlowSourceInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public FlowSourceInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowSourceInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowSourceEntity.INSTANCE, id);
	}
	
	protected FlowSourceInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowSourceInstance, FlowInstance> owner
		= createReverseRelationValue(FlowSourceEntity.owner);

}
