package app.carinsurance.entity;

import java.util.Date;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.AttributeValues;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.instance.value.impl.AttributeValuesImpl;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;
import lbe.model.Relation;

public class DriverInstance extends SimpleInstance {

	public DriverInstance(CaseInstance caseInstance) {
		super(caseInstance, DriverEntity.INSTANCE);
	}

	public final ReadOnlyRelationValue<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase 
		= createReverseRelationValue(DriverEntity.carinsuranceCase);
	
	public final AttributeValue<DriverInstance, Date> dateOfBirth 
		= new AttributeValueImpl<DriverInstance, Date>(this, DriverEntity.dateOfBirth);

	public final AttributeValues<DriverInstance, String> carUse 
		= new AttributeValuesImpl<DriverInstance, String>(this, DriverEntity.carUse);

	public final AttributeValue<DriverInstance, Boolean> disqualified 
		= new AttributeValueImpl<DriverInstance, Boolean>(this, DriverEntity.disqualified);

	public final AttributeValue<DriverInstance, String> zipCode 
		= new AttributeValueImpl<DriverInstance, String>(this, DriverEntity.zipCode);

	public final AttributeValue<DriverInstance, Integer> yearsDriverslicense
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.yearsDriverslicense);

	public final AttributeValue<DriverInstance, Integer> yearsInsured  
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.yearsInsured);

	public final AttributeValue<DriverInstance, String> mileage
		= new AttributeValueImpl<DriverInstance, String>(this, DriverEntity.mileage);

	public final AttributeValue<DriverInstance, Integer> noClaimsDiscount
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.noClaimsDiscount);

}
