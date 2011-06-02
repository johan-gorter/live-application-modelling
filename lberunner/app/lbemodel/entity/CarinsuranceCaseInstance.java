package lbemodel.entity;

import lbe.instance.CaseInstance;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class CarinsuranceCaseInstance extends CaseInstance {

	public final RelationValueImpl<CarinsuranceCaseInstance, DriverInstance> driver 
		= new RelationValueImpl<CarinsuranceCaseInstance, DriverInstance>(this, CarinsuranceCaseEntity.driver, false);

	@Override
	public Entity getModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
}
