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

public class PageFragmentInstance 
	extends SimpleInstance 
	implements Instance {

	public PageFragmentInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentEntity.INSTANCE, id);
	}
	
	protected PageFragmentInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<PageFragmentInstance, java.lang.String> presentation
		= createAttributeValue(PageFragmentEntity.presentation);
	
	public java.lang.String getPresentation() {
		return presentation.get();
	}

	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentInstance, PageFragmentHolderInstance> holder
		= createReverseRelationValue(PageFragmentEntity.holder);
	
	public final ReadOnlyRelationValue<PageFragmentInstance, PageCompositionInstance> composedIn
		= createReverseRelationValue(PageFragmentEntity.composedIn);

}
