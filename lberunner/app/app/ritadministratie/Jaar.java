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

public class Jaar 
	extends SimpleCaseInstance 
	implements Instance {

	public Jaar() {
		super(JaarEntity.INSTANCE, RitAdministratieApplication.INSTANCE);
	}

	// Attributes
	
	public final AttributeValue<Jaar, java.lang.Integer> jaartal
		= createAttributeValue(JaarEntity.jaartal);
	
	public java.lang.Integer getJaartal() {
		return jaartal.get();
	}

	public void setJaartal(java.lang.Integer newValue) {
		jaartal.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<Jaar, Auto> autos
		= createRelationValues(JaarEntity.autos);
		
	public List<Auto> getAutos() {
		return autos.get();
	}
	
	public void setAutos(List<Auto> newValue) {
		autos.set(newValue);
	}

	// Reverse relations

}
