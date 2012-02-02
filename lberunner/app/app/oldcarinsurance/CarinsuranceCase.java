package app.oldcarinsurance;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.impl.SimpleCaseInstance;
import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.oldcarinsurance.entity.CarinsuranceCaseEntity;
import app.oldcarinsurance.entity.DriverEntity;

public class CarinsuranceCase extends SimpleCaseInstance {

	public CarinsuranceCase() {
		super(CarinsuranceCaseEntity.INSTANCE);
	}

	public final RelationValue<CarinsuranceCase, Driver> driver 
		= createRelationValue(CarinsuranceCaseEntity.driver);

	@Override
	public CaseEntity getModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
}
