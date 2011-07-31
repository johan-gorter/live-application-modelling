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

public class PageFragmentHolderInstance 
	extends ConceptInstance 
	implements Instance {

	public PageFragmentHolderInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentHolderInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentHolderEntity.INSTANCE, id);
	}
	
	protected PageFragmentHolderInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageFragmentHolderInstance, PageFragmentInstance> pageFragment
		= createRelationValue(PageFragmentHolderEntity.pageFragment);

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentHolderInstance, SharedInstance> shared
		= createReverseRelationValue(PageFragmentHolderEntity.shared);
	
	public final ReadOnlyRelationValues<PageFragmentHolderInstance, SharedFragmentInstance> usages
		= createReverseRelationValues(PageFragmentHolderEntity.usages);

}
