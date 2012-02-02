package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.PageCompositionDesignEntity;

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
