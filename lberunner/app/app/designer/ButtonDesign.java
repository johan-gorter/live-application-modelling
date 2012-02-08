package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;

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
