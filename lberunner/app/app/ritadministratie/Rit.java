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
	
	public final RelationValue<Rit, Stand> beginstand
		= createRelationValue(RitEntity.beginstand);
		
	public Stand getBeginstand() {
		return beginstand.get();
	}
	
	public void setBeginstand(Stand newValue) {
		beginstand.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<Rit, Dag> dag
		= createReverseRelationValue(RitEntity.dag);

	public Dag getDag() {
		return dag.get();
	}


}
