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

public class SubFlowDesign 
	extends FlowNodeBaseDesign 
	implements Instance {

	public SubFlowDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SubFlowDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SubFlowDesignEntity.INSTANCE, id);
	}
	
	protected SubFlowDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SubFlowDesign, FlowDesign> flow
		= createRelationValue(SubFlowDesignEntity.flow);

	// Reverse relations

}
