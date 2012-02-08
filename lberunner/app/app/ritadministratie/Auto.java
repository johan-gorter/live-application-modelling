package app.ritadministratie;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;

import app.ritadministratie.entity.AutoEntity;

public class Auto 
	extends SimpleInstance 
	implements Instance {

	public Auto(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Auto(CaseInstance caseInstance, long id) {
		super(caseInstance, AutoEntity.INSTANCE, id);
	}
	
	protected Auto(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Auto, java.lang.String> kenteken
		= createAttributeValue(AutoEntity.kenteken);
	
	public java.lang.String getKenteken() {
		return kenteken.get();
	}

	public void setKenteken(java.lang.String newValue) {
		kenteken.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<Auto, Maand> maanden
		= createRelationValues(AutoEntity.maanden);
		
	public List<Maand> getMaanden() {
		return maanden.get();
	}
	
	public void setMaanden(List<Maand> newValue) {
		maanden.set(newValue);
	}
	
	public final RelationValue<Auto, Stand> beginstand
		= createRelationValue(AutoEntity.beginstand);
		
	public Stand getBeginstand() {
		return beginstand.get();
	}
	
	public void setBeginstand(Stand newValue) {
		beginstand.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<Auto, Jaar> jaar
		= createReverseRelationValue(AutoEntity.jaar);

	public Jaar getJaar() {
		return jaar.get();
	}


}
