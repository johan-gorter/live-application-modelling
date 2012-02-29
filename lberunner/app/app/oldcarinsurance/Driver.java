package app.oldcarinsurance;

import java.util.Date;

import app.oldcarinsurance.entity.DriverEntity;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.AttributeValues;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.instance.value.impl.AttributeValuesImpl;
import lbe.instance.value.impl.ReadOnlyAttributeValueImpl;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;
import lbe.model.Relation;

public class Driver extends SimpleInstance {

	public Driver(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Driver(CaseInstance caseInstance, long id) {
		super(caseInstance, DriverEntity.INSTANCE, id);
	}

	public final ReadOnlyRelationValue<Driver, CarinsuranceCase> carinsuranceCase 
		= createReverseRelationValue(DriverEntity.carinsuranceCase);
	
	public final AttributeValue<Driver, Date> dateOfBirth 
		= new AttributeValueImpl<Driver, Date>(this, DriverEntity.dateOfBirth);

	public final AttributeValues<Driver, String> carUse 
		= new AttributeValuesImpl<Driver, String>(this, DriverEntity.carUse);

	public final AttributeValue<Driver, Boolean> disqualified 
		= new AttributeValueImpl<Driver, Boolean>(this, DriverEntity.disqualified);

	public final AttributeValue<Driver, String> zipCode 
		= new AttributeValueImpl<Driver, String>(this, DriverEntity.zipCode);

	public final AttributeValue<Driver, Integer> yearsDriverslicense
		= new AttributeValueImpl<Driver, Integer>(this, DriverEntity.yearsDriverslicense);

	public final AttributeValue<Driver, Integer> yearsInsured  
		= new AttributeValueImpl<Driver, Integer>(this, DriverEntity.yearsInsured);

	public final AttributeValue<Driver, String> mileage
		= new AttributeValueImpl<Driver, String>(this, DriverEntity.mileage);

	public final AttributeValue<Driver, Integer> noClaimsDiscount
	= new AttributeValueImpl<Driver, Integer>(this, DriverEntity.noClaimsDiscount);

	public final ReadOnlyAttributeValue<Driver, Integer> penalty
		= new ReadOnlyAttributeValueImpl<Driver, Integer>(this, DriverEntity.penalty);

}
