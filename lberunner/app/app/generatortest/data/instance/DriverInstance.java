package app.generatortest.data.instance;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.AttributeValues;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.generatortest.data.entity.DriverEntity;

public class DriverInstance 
	extends SimpleInstance 
	implements Instance {

	public DriverInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public DriverInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, DriverEntity.INSTANCE, id);
	}
	
	protected DriverInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<DriverInstance, java.util.Date> dateOfBirth
		= createAttributeValue(DriverEntity.dateOfBirth);
	
	public java.util.Date getDateOfBirth() {
		return dateOfBirth.get();
	}

	
	public final AttributeValues<DriverInstance, java.lang.String> carUse
		= createAttributeValues(DriverEntity.carUse);
	
	public List<java.lang.String> getCarUse() {
		return carUse.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.Boolean> disqualified
		= createAttributeValue(DriverEntity.disqualified);
	
	public java.lang.Boolean getDisqualified() {
		return disqualified.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.String> zipCode
		= createAttributeValue(DriverEntity.zipCode);
	
	public java.lang.String getZipCode() {
		return zipCode.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.Integer> yearsDriverslicense
		= createAttributeValue(DriverEntity.yearsDriverslicense);
	
	public java.lang.Integer getYearsDriverslicense() {
		return yearsDriverslicense.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.Integer> yearsInsured
		= createAttributeValue(DriverEntity.yearsInsured);
	
	public java.lang.Integer getYearsInsured() {
		return yearsInsured.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.String> mileage
		= createAttributeValue(DriverEntity.mileage);
	
	public java.lang.String getMileage() {
		return mileage.get();
	}

	
	public final AttributeValue<DriverInstance, java.lang.Integer> noClaimsDiscount
		= createAttributeValue(DriverEntity.noClaimsDiscount);
	
	public java.lang.Integer getNoClaimsDiscount() {
		return noClaimsDiscount.get();
	}

	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase
		= createReverseRelationValue(DriverEntity.carinsuranceCase);

}
