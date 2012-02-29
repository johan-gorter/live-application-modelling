package app.ritadministratie.entity;

import java.util.List;

import app.ritadministratie.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.deduction.*;

public class TrajectEntity extends SimpleEntity {

	public static final TrajectEntity INSTANCE = new TrajectEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private TrajectEntity() {
		super("Traject");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Traject(caseInstance, id);
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
