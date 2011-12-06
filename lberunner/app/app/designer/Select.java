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

public class Select 
	extends CompositePageFragmentDesign 
	implements Instance {

	public Select(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Select(CaseInstance caseInstance, long id) {
		super(caseInstance, SelectEntity.INSTANCE, id);
	}
	
	protected Select(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<Select, RelationDesign> relation
		= createRelationValue(SelectEntity.relation);
		
	public RelationDesign getRelation() {
		return relation.get();
	}
	
	public void setRelation(RelationDesign newValue) {
		relation.set(newValue);
	}

	// Reverse relations

}
