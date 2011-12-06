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

	public void setDateOfBirth(java.util.Date value) {
		dateOfBirth.set(value);
	}
	
	public final AttributeValues<Driver, java.lang.String> carUse
		= createAttributeValues(DriverEntity.carUse);
	
	public List<java.lang.String> getCarUse() {
		return carUse.get();
	}

	public void setCarUse(List<java.lang.String> value) {
		carUse.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.Boolean> disqualified
		= createAttributeValue(DriverEntity.disqualified);
	
	public java.lang.Boolean getDisqualified() {
		return disqualified.get();
	}

	public void setDisqualified(java.lang.Boolean value) {
		disqualified.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.String> zipCode
		= createAttributeValue(DriverEntity.zipCode);
	
	public java.lang.String getZipCode() {
		return zipCode.get();
	}

	public void setZipCode(java.lang.String value) {
		zipCode.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.Integer> yearsDriverslicense
		= createAttributeValue(DriverEntity.yearsDriverslicense);
	
	public java.lang.Integer getYearsDriverslicense() {
		return yearsDriverslicense.get();
	}

	public void setYearsDriverslicense(java.lang.Integer value) {
		yearsDriverslicense.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.Integer> yearsInsured
		= createAttributeValue(DriverEntity.yearsInsured);
	
	public java.lang.Integer getYearsInsured() {
		return yearsInsured.get();
	}

	public void setYearsInsured(java.lang.Integer value) {
		yearsInsured.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.String> mileage
		= createAttributeValue(DriverEntity.mileage);
	
	public java.lang.String getMileage() {
		return mileage.get();
	}

	public void setMileage(java.lang.String value) {
		mileage.set(value);
	}
	
	public final AttributeValue<Driver, java.lang.Integer> noClaimsDiscount
		= createAttributeValue(DriverEntity.noClaimsDiscount);
	
	public java.lang.Integer getNoClaimsDiscount() {
		return noClaimsDiscount.get();
	}

	public void setNoClaimsDiscount(java.lang.Integer value) {
		noClaimsDiscount.set(value);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<Driver, CarinsuranceCase> carinsuranceCase
		= createReverseRelationValue(DriverEntity.carinsuranceCase);

	public CarinsuranceCase getCarinsuranceCase() {
		return carinsuranceCase.get();
	}


}