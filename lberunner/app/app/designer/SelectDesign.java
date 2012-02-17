package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.SelectDesignEntity;

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
