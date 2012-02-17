package app.ritadministratie;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleCaseInstance;
import org.instantlogic.fabric.model.CaseEntity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.RelationValues;

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
