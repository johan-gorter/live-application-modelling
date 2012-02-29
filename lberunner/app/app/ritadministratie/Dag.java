package app.ritadministratie;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValues;

import app.ritadministratie.entity.DagEntity;

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
