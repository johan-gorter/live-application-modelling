package app.ritadministratie;

import java.util.List;

import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleCaseInstance;
import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.RelationValues;

import app.ritadministratie.entity.JaarEntity;

public class Jaar 
	extends SimpleCaseInstance 
	implements Instance {

	public Jaar() {
		super(JaarEntity.INSTANCE);
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
	
	public final RelationValues<Jaar, Ijking> ijkingen
		= createRelationValues(JaarEntity.ijkingen);
		
	public List<Ijking> getIjkingen() {
		return ijkingen.get();
	}
	
	public void setIjkingen(List<Ijking> newValue) {
		ijkingen.set(newValue);
	}

	@Override
	public CaseEntity getModel() {
		return JaarEntity.INSTANCE;
	}

	// Reverse relations

}
