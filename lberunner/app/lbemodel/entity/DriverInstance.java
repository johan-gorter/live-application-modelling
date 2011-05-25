package lbemodel.entity;

import java.util.Date;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.EntityModel;
import lbemodel.entity.carinsurancecase.DriverRelation;

public class DriverInstance extends Instance {

	private SingleRelationValue<CarinsuranceCaseInstance> carinsuranceCase = new SingleRelationValue<CarinsuranceCaseInstance>(this, DriverRelation.INSTANCE, false);
	
	@Override
	public EntityModel getModel() {
		return DriverEntity.INSTANCE;
	}

	public SingleRelationValue<CarinsuranceCaseInstance> getCarinsuranceCase() {
		return carinsuranceCase;
	}
	
	public AttributeValue<Date> getDateOfBirth() {
		return null;
		
	}
}
