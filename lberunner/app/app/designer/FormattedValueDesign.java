package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.FormattedValueDesignEntity;

public class FormattedValueDesign 
	extends StringProducerDesign 
	implements Instance {

	public FormattedValueDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FormattedValueDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FormattedValueDesignEntity.INSTANCE, id);
	}
	
	protected FormattedValueDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FormattedValueDesign, DeductionSchemeDesign> deduction
		= createRelationValue(FormattedValueDesignEntity.deduction);
		
	public DeductionSchemeDesign getDeduction() {
		return deduction.get();
	}
	
	public void setDeduction(DeductionSchemeDesign newValue) {
		deduction.set(newValue);
	}

	// Reverse relations

}
