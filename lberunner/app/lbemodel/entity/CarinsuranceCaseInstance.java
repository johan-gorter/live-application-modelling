package lbemodel.entity;

import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.EntityModel;
import lbemodel.entity.carinsurancecase.DriverRelation;

public class CarinsuranceCaseInstance extends Instance {

	public CarinsuranceCaseInstance() {
		super(null);
	}
	
	@Override
	public Instance getCase() {
		return this;
	}

	public final SingleRelationValue<CarinsuranceCaseInstance, DriverInstance> driver 
		= new SingleRelationValue<CarinsuranceCaseInstance, DriverInstance>(this, DriverRelation.INSTANCE, false);

	@Override
	public EntityModel getModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
}
