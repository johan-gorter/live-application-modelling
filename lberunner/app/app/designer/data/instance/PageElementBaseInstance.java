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

public class PageElementBaseInstance 
	extends ConceptInstance 
	implements Instance {

	public PageElementBaseInstance(CaseInstance caseInstance) {
		super(caseInstance, PageElementBaseEntity.INSTANCE);
	}
	
	protected PageElementBaseInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValues<PageElementBaseInstance, PageInstance> rootElementInPages
		= createReverseRelationValues(PageElementBaseEntity.rootElementInPages);
	
	public final ReadOnlyRelationValues<PageElementBaseInstance, ContainerInstance> containmentIn
		= createReverseRelationValues(PageElementBaseEntity.containmentIn);

}
