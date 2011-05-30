package lbemodel.entity;

import java.util.Date;

import lbe.instance.AttributeValue;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.Entity;

public class DriverInstance extends Instance {

	public DriverInstance(CaseInstance caseInstance) {
		super(caseInstance);
	}

	@Override
	public Entity getModel() {
		return DriverEntity.INSTANCE;
	}

	public final SingleRelationValue<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase 
		= new SingleRelationValue<DriverInstance, CarinsuranceCaseInstance>(this, DriverEntity.carinsuranceCase, true);
	
	public final AttributeValue<DriverInstance, Date> dateOfBirth 
		= new AttributeValue<DriverInstance, Date>(this, DriverEntity.dateOfBirth);

	public final AttributeValue<DriverInstance, String> carUse 
		= new AttributeValue<DriverInstance, String>(this, DriverEntity.carUse);

	public final AttributeValue<DriverInstance, Boolean> disqualified 
		= new AttributeValue<DriverInstance, Boolean>(this, DriverEntity.disqualified);

	public final AttributeValue<DriverInstance, String> zipCode 
		= new AttributeValue<DriverInstance, String>(this, DriverEntity.zipCode);

	public final AttributeValue<DriverInstance, Integer> yearsDriverslicense
		= new AttributeValue<DriverInstance, Integer>(this, DriverEntity.yearsDriverslicense);

	public final AttributeValue<DriverInstance, Integer> yearsInsured  
		= new AttributeValue<DriverInstance, Integer>(this, DriverEntity.yearsInsured);

	public final AttributeValue<DriverInstance, String> mileage
		= new AttributeValue<DriverInstance, String>(this, DriverEntity.mileage);

	public final AttributeValue<DriverInstance, Integer> noClaimsDiscount
		= new AttributeValue<DriverInstance, Integer>(this, DriverEntity.noClaimsDiscount);

}
