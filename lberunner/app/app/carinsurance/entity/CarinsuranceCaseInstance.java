package app.carinsurance.entity;

import lbe.instance.CaseInstance;
import lbe.instance.impl.SimpleCaseInstance;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class CarinsuranceCaseInstance extends SimpleCaseInstance {

	public CarinsuranceCaseInstance() {
		super(CarinsuranceCaseEntity.INSTANCE);
	}

	public final RelationValueImpl<CarinsuranceCaseInstance, DriverInstance> driver 
		= new RelationValueImpl<CarinsuranceCaseInstance, DriverInstance>(this, CarinsuranceCaseEntity.driver);

}
