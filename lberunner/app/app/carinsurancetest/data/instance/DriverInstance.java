package app.carinsurancetest.data.instance;

import java.util.List;

import app.carinsurancetest.*;
import app.carinsurancetest.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

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
	
	public final AttributeValues<DriverInstance, java.lang.String> carUse
		= createAttributeValues(DriverEntity.carUse);
	
	public final AttributeValue<DriverInstance, java.lang.Boolean> disqualified
		= createAttributeValue(DriverEntity.disqualified);
	
	public final AttributeValue<DriverInstance, java.lang.String> zipCode
		= createAttributeValue(DriverEntity.zipCode);
	
	public final AttributeValue<DriverInstance, java.lang.Integer> yearsDriverslicense
		= createAttributeValue(DriverEntity.yearsDriverslicense);
	
	public final AttributeValue<DriverInstance, java.lang.Integer> yearsInsured
		= createAttributeValue(DriverEntity.yearsInsured);
	
	public final AttributeValue<DriverInstance, java.lang.String> mileage
		= createAttributeValue(DriverEntity.mileage);
	
	public final AttributeValue<DriverInstance, java.lang.Integer> noClaimsDiscount
		= createAttributeValue(DriverEntity.noClaimsDiscount);
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase
		= createReverseRelationValue(DriverEntity.carinsuranceCase);

}
