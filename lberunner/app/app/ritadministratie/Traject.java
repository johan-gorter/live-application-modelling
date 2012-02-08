package app.ritadministratie;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;

import app.ritadministratie.entity.TrajectEntity;

public class Traject 
	extends SimpleInstance 
	implements Instance {

	public Traject(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Traject(CaseInstance caseInstance, long id) {
		super(caseInstance, TrajectEntity.INSTANCE, id);
	}
	
	protected Traject(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
