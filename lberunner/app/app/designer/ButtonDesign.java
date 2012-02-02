package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;

import app.designer.entity.ButtonDesignEntity;

public class ButtonDesign 
	extends LinkDesign 
	implements Instance {

	public ButtonDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ButtonDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, ButtonDesignEntity.INSTANCE, id);
	}
	
	protected ButtonDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
