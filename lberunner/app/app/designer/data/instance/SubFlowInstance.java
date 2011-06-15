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

public class SubFlowInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public SubFlowInstance(CaseInstance caseInstance) {
		super(caseInstance, SubFlowEntity.INSTANCE);
	}
	
	protected SubFlowInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
