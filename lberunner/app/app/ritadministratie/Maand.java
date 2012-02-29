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

public class Maand 
	extends SimpleInstance 
	implements Instance {

	public Maand(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Maand(CaseInstance caseInstance, long id) {
		super(caseInstance, MaandEntity.INSTANCE, id);
	}
	
	protected Maand(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Maand, java.lang.Integer> maandNr
		= createAttributeValue(MaandEntity.maandNr);
	
	public java.lang.Integer getMaandNr() {
		return maandNr.get();
	}

	public void setMaandNr(java.lang.Integer newValue) {
		maandNr.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<Maand, Dag> dagen
		= createRelationValues(MaandEntity.dagen);
		
	public List<Dag> getDagen() {
		return dagen.get();
	}
	
	public void setDagen(List<Dag> newValue) {
		dagen.set(newValue);
	}
	
	public final RelationValue<Maand, Stand> beginstand
		= createRelationValue(MaandEntity.beginstand);
		
	public Stand getBeginstand() {
		return beginstand.get();
	}
	
	public void setBeginstand(Stand newValue) {
		beginstand.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<Maand, Auto> auto
		= createReverseRelationValue(MaandEntity.auto);

	public Auto getAuto() {
		return auto.get();
	}


}
