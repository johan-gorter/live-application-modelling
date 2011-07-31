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

public class PageInstance 
	extends FlowNodeBaseInstance 
	implements Instance {

	public PageInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, PageEntity.INSTANCE, id);
	}
	
	protected PageInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageInstance, CompositePageFragmentInstance> content
		= createRelationValue(PageEntity.content);

	// Reverse relations

}
