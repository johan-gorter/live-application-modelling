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

public class LinkInstance 
	extends PageFragmentInstance 
	implements Instance {

	public LinkInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public LinkInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, LinkEntity.INSTANCE, id);
	}
	
	protected LinkInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<LinkInstance, TextInstance> caption
		= createRelationValue(LinkEntity.caption);
	
	public final RelationValue<LinkInstance, EventInstance> event
		= createRelationValue(LinkEntity.event);

	// Reverse relations

}
