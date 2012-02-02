package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.AttributeValue;

import app.designer.entity.ConstantTextDesignEntity;

public class ConstantTextDesign 
	extends TextDesign 
	implements Instance {

	public ConstantTextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConstantTextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, ConstantTextDesignEntity.INSTANCE, id);
	}
	
	protected ConstantTextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConstantTextDesign, java.lang.String> untranslated
		= createAttributeValue(ConstantTextDesignEntity.untranslated);
	
	public java.lang.String getUntranslated() {
		return untranslated.get();
	}

	public void setUntranslated(java.lang.String newValue) {
		untranslated.set(newValue);
	}
	
	// Relations

	// Reverse relations

}
