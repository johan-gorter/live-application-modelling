package lbemodel.entity;

import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.EntityModel;
import lbemodel.entity.carinsurancecase.DriverRelation;

public class CarinsuranceCaseInstance extends Instance {

	private SingleRelationValue<DriverInstance> driver = new SingleRelationValue<DriverInstance>(this, DriverRelation.INSTANCE, false);

	@Override
	public EntityModel getModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	public SingleRelationValue<DriverInstance> getDriver() {
		return driver;
	}
}
