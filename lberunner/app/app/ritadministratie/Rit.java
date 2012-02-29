package app.ritadministratie;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;

import app.ritadministratie.entity.RitEntity;

public class Rit 
	extends SimpleInstance 
	implements Instance {

	public Rit(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Rit(CaseInstance caseInstance, long id) {
		super(caseInstance, RitEntity.INSTANCE, id);
	}
	
	protected Rit(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Rit, java.lang.String> via
		= createAttributeValue(RitEntity.via);
	
	public java.lang.String getVia() {
		return via.get();
	}

	public void setVia(java.lang.String newValue) {
		via.set(newValue);
	}
	
	public final AttributeValue<Rit, java.lang.Integer> priveKm
		= createAttributeValue(RitEntity.priveKm);
	
	public java.lang.Integer getPriveKm() {
		return priveKm.get();
	}

	public void setPriveKm(java.lang.Integer newValue) {
		priveKm.set(newValue);
	}
	
	public final AttributeValue<Rit, java.lang.Boolean> priveRit
		= createAttributeValue(RitEntity.priveRit);
	
	public java.lang.Boolean getPriveRit() {
		return priveRit.get();
	}

	public void setPriveRit(java.lang.Boolean newValue) {
		priveRit.set(newValue);
	}
	
	// Relations
	
	public final RelationValue<Rit, Stand> eindstand
		= createRelationValue(RitEntity.eindstand);
		
	public Stand getEindstand() {
		return eindstand.get();
	}
	
	public void setEindstand(Stand newValue) {
		eindstand.set(newValue);
	}
	
	public final ReadOnlyRelationValue<Rit, Stand> beginstand
		= createReadOnlyRelationValue(RitEntity.beginstand);
		
	public Stand getBeginstand() {
		return beginstand.get();
	}
	

	// Reverse relations
	
	public final ReadOnlyRelationValue<Rit, Dag> dag
		= createReverseRelationValue(RitEntity.dag);

	public Dag getDag() {
		return dag.get();
	}


}
