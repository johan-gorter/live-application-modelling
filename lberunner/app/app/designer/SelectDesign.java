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

public class SelectDesign 
	extends CompositePageFragmentDesign 
	implements Instance {

	public SelectDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SelectDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SelectDesignEntity.INSTANCE, id);
	}
	
	protected SelectDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SelectDesign, DeductionSchemeDesign> deduction
		= createRelationValue(SelectDesignEntity.deduction);
		
	public DeductionSchemeDesign getDeduction() {
		return deduction.get();
	}
	
	public void setDeduction(DeductionSchemeDesign newValue) {
		deduction.set(newValue);
	}

	// Reverse relations

}
