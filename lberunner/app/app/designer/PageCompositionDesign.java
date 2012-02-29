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

public class PageCompositionDesign 
	extends SimpleInstance 
	implements Instance {

	public PageCompositionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageCompositionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, PageCompositionDesignEntity.INSTANCE, id);
	}
	
	protected PageCompositionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageCompositionDesign, PageFragmentDesign> pageFragment
		= createRelationValue(PageCompositionDesignEntity.pageFragment);
		
	public PageFragmentDesign getPageFragment() {
		return pageFragment.get();
	}
	
	public void setPageFragment(PageFragmentDesign newValue) {
		pageFragment.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageCompositionDesign, CompositePageFragmentDesign> itemIn
		= createReverseRelationValue(PageCompositionDesignEntity.itemIn);

	public CompositePageFragmentDesign getItemIn() {
		return itemIn.get();
	}


}
