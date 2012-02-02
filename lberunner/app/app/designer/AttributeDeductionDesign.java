package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.AttributeDeductionDesignEntity;

public class AttributeDeductionDesign 
	extends DeductionDesign 
	implements Instance {

	public AttributeDeductionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeDeductionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeDeductionDesignEntity.INSTANCE, id);
	}
	
	protected AttributeDeductionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<AttributeDeductionDesign, AttributeDesign> attribute
		= createRelationValue(AttributeDeductionDesignEntity.attribute);
		
	public AttributeDesign getAttribute() {
		return attribute.get();
	}
	
	public void setAttribute(AttributeDesign newValue) {
		attribute.set(newValue);
	}

	// Reverse relations

}
