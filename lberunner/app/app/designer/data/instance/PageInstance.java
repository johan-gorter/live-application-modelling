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

public class PageInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public PageInstance(CaseInstance caseInstance) {
		super(caseInstance, PageEntity.INSTANCE);
	}
	
	protected PageInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<PageInstance, PageElementBaseInstance> rootElements
		= createRelationValues(PageEntity.rootElements);

	// Reverse relations

}
