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

public class SharedTextInstance 
	extends TextInstance 
	implements Instance {

	public SharedTextInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedTextInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedTextEntity.INSTANCE, id);
	}
	
	protected SharedTextInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SharedTextInstance, TextHolderInstance> holder
		= createRelationValue(SharedTextEntity.holder);

	// Reverse relations

}
