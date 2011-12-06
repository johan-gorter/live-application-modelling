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

public class Shared 
	extends SimpleInstance 
	implements Instance {

	public Shared(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Shared(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedEntity.INSTANCE, id);
	}
	
	protected Shared(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<Shared, PageFragmentHolder> pageFragments
		= createRelationValues(SharedEntity.pageFragments);
		
	public List<PageFragmentHolder> getPageFragments() {
		return pageFragments.get();
	}
	
	public void setPageFragments(List<PageFragmentHolder> newValue) {
		pageFragments.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<Shared, ApplicationDesign> application
		= createReverseRelationValue(SharedEntity.application);

	public ApplicationDesign getApplication() {
		return application.get();
	}


}
