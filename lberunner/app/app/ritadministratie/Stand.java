package app.ritadministratie;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.ritadministratie.entity.StandEntity;

public class Stand 
	extends SimpleInstance 
	implements Instance {

	public Stand(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Stand(CaseInstance caseInstance, long id) {
		super(caseInstance, StandEntity.INSTANCE, id);
	}
	
	protected Stand(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Stand, java.lang.Integer> kmStand
		= createAttributeValue(StandEntity.kmStand);
	
	public java.lang.Integer getKmStand() {
		return kmStand.get();
	}

	public void setKmStand(java.lang.Integer newValue) {
		kmStand.set(newValue);
	}
	
	public final AttributeValue<Stand, java.lang.String> adres
		= createAttributeValue(StandEntity.adres);
	
	public java.lang.String getAdres() {
		return adres.get();
	}

	public void setAdres(java.lang.String newValue) {
		adres.set(newValue);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<Stand, Auto> beginstandVanAuto
		= createReverseRelationValue(StandEntity.beginstandVanAuto);

	public Auto getBeginstandVanAuto() {
		return beginstandVanAuto.get();
	}

	
	public final ReadOnlyRelationValue<Stand, Maand> beginstandVanMaand
		= createReverseRelationValue(StandEntity.beginstandVanMaand);

	public Maand getBeginstandVanMaand() {
		return beginstandVanMaand.get();
	}

	
	public final ReadOnlyRelationValue<Stand, Rit> eindstandVanRit
		= createReverseRelationValue(StandEntity.eindstandVanRit);

	public Rit getEindstandVanRit() {
		return eindstandVanRit.get();
	}

	
	public final ReadOnlyRelationValue<Stand, Rit> beginstandVanRit
		= createReverseRelationValue(StandEntity.beginstandVanRit);

	public Rit getBeginstandVanRit() {
		return beginstandVanRit.get();
	}


}
