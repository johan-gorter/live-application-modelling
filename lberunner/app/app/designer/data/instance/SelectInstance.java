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

public class SelectInstance 
	extends CompositePageFragmentInstance 
	implements Instance {

	public SelectInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SelectInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, SelectEntity.INSTANCE, id);
	}
	
	protected SelectInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SelectInstance, RelationInstance> relation
		= createRelationValue(SelectEntity.relation);

	// Reverse relations

}
