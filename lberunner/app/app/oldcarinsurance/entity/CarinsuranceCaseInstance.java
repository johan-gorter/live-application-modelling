package app.oldcarinsurance.entity;

import app.oldcarinsurance.CarinsuranceApplication;
import lbe.instance.CaseInstance;
import lbe.instance.impl.SimpleCaseInstance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class CarinsuranceCaseInstance extends SimpleCaseInstance {

	public CarinsuranceCaseInstance() {
		super(CarinsuranceCaseEntity.INSTANCE, CarinsuranceApplication.INSTANCE );
	}

	public final RelationValue<CarinsuranceCaseInstance, DriverInstance> driver 
		= createRelationValue(CarinsuranceCaseEntity.driver);

}
