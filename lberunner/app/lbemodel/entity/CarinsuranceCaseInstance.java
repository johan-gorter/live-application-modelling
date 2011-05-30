package lbemodel.entity;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.Entity;

public class CarinsuranceCaseInstance extends CaseInstance {

	public final SingleRelationValue<CarinsuranceCaseInstance, DriverInstance> driver 
		= new SingleRelationValue<CarinsuranceCaseInstance, DriverInstance>(this, CarinsuranceCaseEntity.driver, false);

	@Override
	public Entity getModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
}
