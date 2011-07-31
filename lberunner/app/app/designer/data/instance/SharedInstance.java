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

public class SharedInstance 
	extends SimpleInstance 
	implements Instance {

	public SharedInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedEntity.INSTANCE, id);
	}
	
	protected SharedInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<SharedInstance, PageFragmentHolderInstance> pageFragments
		= createRelationValues(SharedEntity.pageFragments);
	
	public final RelationValues<SharedInstance, TextHolderInstance> texts
		= createRelationValues(SharedEntity.texts);

	// Reverse relations
	
	public final ReadOnlyRelationValue<SharedInstance, ApplicationInstance> application
		= createReverseRelationValue(SharedEntity.application);

}
