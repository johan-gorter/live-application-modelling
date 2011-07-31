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

public class SharedFragmentInstance 
	extends PageFragmentInstance 
	implements Instance {

	public SharedFragmentInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedFragmentInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedFragmentEntity.INSTANCE, id);
	}
	
	protected SharedFragmentInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SharedFragmentInstance, PageFragmentHolderInstance> holder
		= createRelationValue(SharedFragmentEntity.holder);

	// Reverse relations

}
