package app.oldcarinsurance;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.impl.SimpleCaseInstance;
import org.instantlogic.fabric.model.CaseEntity;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.RelationValue;

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
