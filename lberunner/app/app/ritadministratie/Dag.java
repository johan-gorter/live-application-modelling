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

public class Dag 
	extends SimpleInstance 
	implements Instance {

	public Dag(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Dag(CaseInstance caseInstance, long id) {
		super(caseInstance, DagEntity.INSTANCE, id);
	}
	
	protected Dag(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Dag, java.lang.Integer> dagNr
		= createAttributeValue(DagEntity.dagNr);
	
	public java.lang.Integer getDagNr() {
		return dagNr.get();
	}

	public void setDagNr(java.lang.Integer newValue) {
		dagNr.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<Dag, Rit> ritten
		= createRelationValues(DagEntity.ritten);
		
	public List<Rit> getRitten() {
		return ritten.get();
	}
	
	public void setRitten(List<Rit> newValue) {
		ritten.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<Dag, Maand> maand
		= createReverseRelationValue(DagEntity.maand);

	public Maand getMaand() {
		return maand.get();
	}


}
