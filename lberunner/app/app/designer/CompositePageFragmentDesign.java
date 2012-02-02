package app.designer;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.RelationValues;

import app.designer.entity.CompositePageFragmentDesignEntity;

public class CompositePageFragmentDesign 
	extends PageFragmentDesign 
	implements Instance {

	public CompositePageFragmentDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public CompositePageFragmentDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, CompositePageFragmentDesignEntity.INSTANCE, id);
	}
	
	protected CompositePageFragmentDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<CompositePageFragmentDesign, PageCompositionDesign> items
		= createRelationValues(CompositePageFragmentDesignEntity.items);
		
	public List<PageCompositionDesign> getItems() {
		return items.get();
	}
	
	public void setItems(List<PageCompositionDesign> newValue) {
		items.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<CompositePageFragmentDesign, PageDesign> contentOfPage
		= createReverseRelationValue(CompositePageFragmentDesignEntity.contentOfPage);

	public PageDesign getContentOfPage() {
		return contentOfPage.get();
	}


}
