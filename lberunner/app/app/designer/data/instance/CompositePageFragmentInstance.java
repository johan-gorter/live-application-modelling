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

public class CompositePageFragmentInstance 
	extends PageFragmentInstance 
	implements Instance {

	public CompositePageFragmentInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public CompositePageFragmentInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, CompositePageFragmentEntity.INSTANCE, id);
	}
	
	protected CompositePageFragmentInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<CompositePageFragmentInstance, PageCompositionInstance> items
		= createRelationValues(CompositePageFragmentEntity.items);

	// Reverse relations
	
	public final ReadOnlyRelationValue<CompositePageFragmentInstance, PageInstance> contentOfPage
		= createReverseRelationValue(CompositePageFragmentEntity.contentOfPage);

}
