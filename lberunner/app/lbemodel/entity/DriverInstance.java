package lbemodel.entity;

import java.util.Date;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.EntityModel;
import lbemodel.entity.driver.CarUseAttribute;
import lbemodel.entity.driver.DateOfBirthAttribute;
import lbemodel.entity.driver.DisqualifiedAttribute;
import lbemodel.entity.driver.MileageAttribute;
import lbemodel.entity.driver.NoClaimsDiscountAttribute;
import lbemodel.entity.driver.YearsDriverslicenseAttribute;
import lbemodel.entity.driver.YearsInsuredAttribute;
import lbemodel.entity.driver.ZipCodeAttribute;

public class DriverInstance extends Instance {

	public DriverInstance(Instance caseInstance) {
		super(caseInstance);
	}

	@Override
	public EntityModel getModel() {
		return DriverEntity.INSTANCE;
	}

	public final SingleRelationValue<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase 
		= new SingleRelationValue<DriverInstance, CarinsuranceCaseInstance>(this, DriverEntity.CaseRelation.INSTANCE, true);
	
	public final AttributeValue<DriverInstance, Date> dateOfBirth 
		= new AttributeValue<DriverInstance, Date>(this, DateOfBirthAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, String> carUse 
		= new AttributeValue<DriverInstance, String>(this, CarUseAttribute.INSTANCE);; 

	public final AttributeValue<DriverInstance, Boolean> disqualified 
		= new AttributeValue<DriverInstance, Boolean>(this, DisqualifiedAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, String> zipCode 
		= new AttributeValue<DriverInstance, String>(this, ZipCodeAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, Integer> yearsDriverslicense
		= new AttributeValue<DriverInstance, Integer>(this, YearsDriverslicenseAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, Integer> yearsInsured  
		= new AttributeValue<DriverInstance, Integer>(this, YearsInsuredAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, String> mileage
		= new AttributeValue<DriverInstance, String>(this, MileageAttribute.INSTANCE);

	public final AttributeValue<DriverInstance, Integer> noClaimsDiscount
		= new AttributeValue<DriverInstance, Integer>(this, NoClaimsDiscountAttribute.INSTANCE);

}
