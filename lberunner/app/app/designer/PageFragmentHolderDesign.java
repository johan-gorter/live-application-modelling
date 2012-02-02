package app.designer;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.ReadOnlyRelationValues;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.PageFragmentHolderDesignEntity;

public class PageFragmentHolderDesign 
	extends Design 
	implements Instance {

	public PageFragmentHolderDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentHolderDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentHolderDesignEntity.INSTANCE, id);
	}
	
	protected PageFragmentHolderDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageFragmentHolderDesign, PageFragmentDesign> pageFragment
		= createRelationValue(PageFragmentHolderDesignEntity.pageFragment);
		
	public PageFragmentDesign getPageFragment() {
		return pageFragment.get();
	}
	
	public void setPageFragment(PageFragmentDesign newValue) {
		pageFragment.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> shared
		= createReverseRelationValue(PageFragmentHolderDesignEntity.shared);

	public ApplicationDesign getShared() {
		return shared.get();
	}

	
	public final ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> usages
		= createReverseRelationValues(PageFragmentHolderDesignEntity.usages);

	public List<SharedFragmentDesign> getUsages() {
		return usages.get();
	}


}
