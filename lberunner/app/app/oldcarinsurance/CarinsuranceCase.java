package app.oldcarinsurance;

import app.oldcarinsurance.entity.CarinsuranceCaseEntity;
import lbe.instance.CaseInstance;
import lbe.instance.impl.SimpleCaseInstance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Entity;

public class CarinsuranceCase extends SimpleCaseInstance {

	public CarinsuranceCase() {
		super(CarinsuranceCaseEntity.INSTANCE, CarinsuranceApplication.INSTANCE );
	}

	public final RelationValue<CarinsuranceCase, Driver> driver 
		= createRelationValue(CarinsuranceCaseEntity.driver);

}
