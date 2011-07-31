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

public class HeaderInstance 
	extends CompositePageFragmentInstance 
	implements Instance {

	public HeaderInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public HeaderInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, HeaderEntity.INSTANCE, id);
	}
	
	protected HeaderInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<HeaderInstance, TextInstance> text
		= createRelationValue(HeaderEntity.text);

	// Reverse relations

}
