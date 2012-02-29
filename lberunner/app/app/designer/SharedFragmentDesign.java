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

public class SharedFragmentDesign 
	extends PageFragmentDesign 
	implements Instance {

	public SharedFragmentDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedFragmentDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedFragmentDesignEntity.INSTANCE, id);
	}
	
	protected SharedFragmentDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SharedFragmentDesign, PageFragmentHolderDesign> holder
		= createRelationValue(SharedFragmentDesignEntity.holder);
		
	public PageFragmentHolderDesign getHolder() {
		return holder.get();
	}
	
	public void setHolder(PageFragmentHolderDesign newValue) {
		holder.set(newValue);
	}

	// Reverse relations

}
