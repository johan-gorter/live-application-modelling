package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;

import app.designer.entity.SharedTextDesignEntity;

public class SharedTextDesign 
	extends TextDesign 
	implements Instance {

	public SharedTextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedTextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedTextDesignEntity.INSTANCE, id);
	}
	
	protected SharedTextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
