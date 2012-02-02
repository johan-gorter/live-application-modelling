package app.oldcarinsurance;

import java.util.Date;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.AttributeValues;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.impl.AttributeValueImpl;
import org.instantlogic.core.value.impl.AttributeValuesImpl;
import org.instantlogic.core.value.impl.ReadOnlyAttributeValueImpl;

import app.oldcarinsurance.entity.DriverEntity;


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
