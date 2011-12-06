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

public class PageComposition 
	extends SimpleInstance 
	implements Instance {

	public PageComposition(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageComposition(CaseInstance caseInstance, long id) {
		super(caseInstance, PageCompositionEntity.INSTANCE, id);
	}
	
	protected PageComposition(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageComposition, PageFragmentDesign> pageFragment
		= createRelationValue(PageCompositionEntity.pageFragment);
		
	public PageFragmentDesign getPageFragment() {
		return pageFragment.get();
	}
	
	public void setPageFragment(PageFragmentDesign newValue) {
		pageFragment.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageComposition, CompositePageFragmentDesign> itemIn
		= createReverseRelationValue(PageCompositionEntity.itemIn);

	public CompositePageFragmentDesign getItemIn() {
		return itemIn.get();
	}


}
