package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.AttributeValue;

import app.designer.entity.ConstantStringDesignEntity;

public class ConstantStringDesign 
	extends StringProducerDesign 
	implements Instance {

	public ConstantStringDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConstantStringDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, ConstantStringDesignEntity.INSTANCE, id);
	}
	
	protected ConstantStringDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConstantStringDesign, java.lang.String> constant
		= createAttributeValue(ConstantStringDesignEntity.constant);
	
	public java.lang.String getConstant() {
		return constant.get();
	}

	public void setConstant(java.lang.String newValue) {
		constant.set(newValue);
	}
	
	// Relations

	// Reverse relations

}
