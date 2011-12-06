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
	
	public final RelationValues<CompositePageFragmentDesign, PageComposition> items
		= createRelationValues(CompositePageFragmentDesignEntity.items);
		
	public List<PageComposition> getItems() {
		return items.get();
	}
	
	public void setItems(List<PageComposition> newValue) {
		items.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<CompositePageFragmentDesign, PageDesign> contentOfPage
		= createReverseRelationValue(CompositePageFragmentDesignEntity.contentOfPage);

	public PageDesign getContentOfPage() {
		return contentOfPage.get();
	}


}
