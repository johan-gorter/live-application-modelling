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

public class TemplatedTextInstance 
	extends TextInstance 
	implements Instance {

	public TemplatedTextInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TemplatedTextInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, TemplatedTextEntity.INSTANCE, id);
	}
	
	protected TemplatedTextInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<TemplatedTextInstance, StringProducerInstance> untranslated
		= createRelationValues(TemplatedTextEntity.untranslated);

	// Reverse relations

}
