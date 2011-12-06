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

public class PageFragmentHolder 
	extends Concept 
	implements Instance {

	public PageFragmentHolder(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentHolder(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentHolderEntity.INSTANCE, id);
	}
	
	protected PageFragmentHolder(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageFragmentHolder, PageFragmentDesign> pageFragment
		= createRelationValue(PageFragmentHolderEntity.pageFragment);
		
	public PageFragmentDesign getPageFragment() {
		return pageFragment.get();
	}
	
	public void setPageFragment(PageFragmentDesign newValue) {
		pageFragment.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentHolder, Shared> shared
		= createReverseRelationValue(PageFragmentHolderEntity.shared);

	public Shared getShared() {
		return shared.get();
	}

	
	public final ReadOnlyRelationValues<PageFragmentHolder, SharedFragment> usages
		= createReverseRelationValues(PageFragmentHolderEntity.usages);

	public List<SharedFragment> getUsages() {
		return usages.get();
	}


}
