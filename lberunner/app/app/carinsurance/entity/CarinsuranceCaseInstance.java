package app.carinsurance.entity;

import lbe.instance.CaseInstance;
import lbe.instance.impl.SimpleCaseInstance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class CarinsuranceCaseInstance extends SimpleCaseInstance {

	public CarinsuranceCaseInstance() {
		super(CarinsuranceCaseEntity.INSTANCE);
	}

	public final RelationValue<CarinsuranceCaseInstance, DriverInstance> driver 
		= createRelationValue(CarinsuranceCaseEntity.driver);

}
