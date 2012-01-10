package app.ritadministratie;

import java.util.List;

import app.ritadministratie.*;
import app.ritadministratie.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

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
