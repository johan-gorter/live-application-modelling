package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageFragmentDesign 
	extends Design 
	implements Instance {

	public PageFragmentDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentDesignEntity.INSTANCE, id);
	}
	
	protected PageFragmentDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<PageFragmentDesign, java.lang.String> presentation
		= createAttributeValue(PageFragmentDesignEntity.presentation);
	
	public java.lang.String getPresentation() {
		return presentation.get();
	}

	public void setPresentation(java.lang.String newValue) {
		presentation.set(newValue);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentDesign, PageFragmentHolderDesign> holder
		= createReverseRelationValue(PageFragmentDesignEntity.holder);

	public PageFragmentHolderDesign getHolder() {
		return holder.get();
	}

	
	public final ReadOnlyRelationValue<PageFragmentDesign, PageCompositionDesign> composedIn
		= createReverseRelationValue(PageFragmentDesignEntity.composedIn);

	public PageCompositionDesign getComposedIn() {
		return composedIn.get();
	}


}
