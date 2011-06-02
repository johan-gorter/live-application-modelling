package lbemodel.entity;

import java.util.Date;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class DriverInstance extends Instance {

	public DriverInstance(CaseInstance caseInstance) {
		super(caseInstance);
	}

	@Override
	public Entity getModel() {
		return DriverEntity.INSTANCE;
	}

	public final RelationValueImpl<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase 
		= new RelationValueImpl<DriverInstance, CarinsuranceCaseInstance>(this, DriverEntity.carinsuranceCase, true);
	
	public final AttributeValueImpl<DriverInstance, Date> dateOfBirth 
		= new AttributeValueImpl<DriverInstance, Date>(this, DriverEntity.dateOfBirth);

	public final AttributeValueImpl<DriverInstance, String> carUse 
		= new AttributeValueImpl<DriverInstance, String>(this, DriverEntity.carUse);

	public final AttributeValueImpl<DriverInstance, Boolean> disqualified 
		= new AttributeValueImpl<DriverInstance, Boolean>(this, DriverEntity.disqualified);

	public final AttributeValueImpl<DriverInstance, String> zipCode 
		= new AttributeValueImpl<DriverInstance, String>(this, DriverEntity.zipCode);

	public final AttributeValueImpl<DriverInstance, Integer> yearsDriverslicense
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.yearsDriverslicense);

	public final AttributeValueImpl<DriverInstance, Integer> yearsInsured  
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.yearsInsured);

	public final AttributeValueImpl<DriverInstance, String> mileage
		= new AttributeValueImpl<DriverInstance, String>(this, DriverEntity.mileage);

	public final AttributeValueImpl<DriverInstance, Integer> noClaimsDiscount
		= new AttributeValueImpl<DriverInstance, Integer>(this, DriverEntity.noClaimsDiscount);

}
