package app.carinsurance;

import java.util.List;

import app.carinsurance.*;
import app.carinsurance.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class Driver 
	extends SimpleInstance 
	implements Instance {

	public Driver(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Driver(CaseInstance caseInstance, long id) {
		super(caseInstance, DriverEntity.INSTANCE, id);
	}
	
	protected Driver(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Driver, java.util.Date> dateOfBirth
		= createAttributeValue(DriverEntity.dateOfBirth);
	
	public java.util.Date getDateOfBirth() {
		return dateOfBirth.get();
	}

	
	public final AttributeValues<Driver, java.lang.String> carUse
		= createAttributeValues(DriverEntity.carUse);
	
	public List<java.lang.String> getCarUse() {
		return carUse.get();
	}

	
	public final AttributeValue<Driver, java.lang.Boolean> disqualified
		= createAttributeValue(DriverEntity.disqualified);
	
	public java.lang.Boolean getDisqualified() {
		return disqualified.get();
	}

	
	public final AttributeValue<Driver, java.lang.String> zipCode
		= createAttributeValue(DriverEntity.zipCode);
	
	public java.lang.String getZipCode() {
		return zipCode.get();
	}

	
	public final AttributeValue<Driver, java.lang.Integer> yearsDriverslicense
		= createAttributeValue(DriverEntity.yearsDriverslicense);
	
	public java.lang.Integer getYearsDriverslicense() {
		return yearsDriverslicense.get();
	}

	
	public final AttributeValue<Driver, java.lang.Integer> yearsInsured
		= createAttributeValue(DriverEntity.yearsInsured);
	
	public java.lang.Integer getYearsInsured() {
		return yearsInsured.get();
	}

	
	public final AttributeValue<Driver, java.lang.String> mileage
		= createAttributeValue(DriverEntity.mileage);
	
	public java.lang.String getMileage() {
		return mileage.get();
	}

	
	public final AttributeValue<Driver, java.lang.Integer> noClaimsDiscount
		= createAttributeValue(DriverEntity.noClaimsDiscount);
	
	public java.lang.Integer getNoClaimsDiscount() {
		return noClaimsDiscount.get();
	}

	
	public final AttributeValue<Driver, java.lang.String> Test
		= createAttributeValue(DriverEntity.Test);
	
	public java.lang.String getTest() {
		return Test.get();
	}

	
	public final AttributeValue<Driver, java.lang.String> NewAttribute1323119309
		= createAttributeValue(DriverEntity.NewAttribute1323119309);
	
	public java.lang.String getNewAttribute1323119309() {
		return NewAttribute1323119309.get();
	}

	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<Driver, CarinsuranceCase> carinsuranceCase
		= createReverseRelationValue(DriverEntity.carinsuranceCase);

}
