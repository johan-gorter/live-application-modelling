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

public class SharedFragment 
	extends PageFragmentDesign 
	implements Instance {

	public SharedFragment(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedFragment(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedFragmentEntity.INSTANCE, id);
	}
	
	protected SharedFragment(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SharedFragment, PageFragmentHolder> holder
		= createRelationValue(SharedFragmentEntity.holder);
		
	public PageFragmentHolder getHolder() {
		return holder.get();
	}
	
	public void setHolder(PageFragmentHolder newValue) {
		holder.set(newValue);
	}

	// Reverse relations

}
