package app.ritadministratie;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.ritadministratie.entity.IjkingEntity;

public class Ijking 
	extends SimpleInstance 
	implements Instance {

	public Ijking(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Ijking(CaseInstance caseInstance, long id) {
		super(caseInstance, IjkingEntity.INSTANCE, id);
	}
	
	protected Ijking(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<Ijking, Jaar> jaar
		= createReverseRelationValue(IjkingEntity.jaar);

	public Jaar getJaar() {
		return jaar.get();
	}


}
