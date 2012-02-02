package app.carinsurance;

import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleCaseInstance;
import org.instantlogic.core.value.RelationValue;

import app.carinsurance.entity.CarinsuranceCaseEntity;

public class CarinsuranceCase 
	extends SimpleCaseInstance 
	implements Instance {

	public CarinsuranceCase() {
		super(CarinsuranceCaseEntity.INSTANCE, CarInsuranceApplication.INSTANCE);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<CarinsuranceCase, Driver> driver
		= createRelationValue(CarinsuranceCaseEntity.driver);
		
	public Driver getDriver() {
		return driver.get();
	}
	
	public void setDriver(Driver newValue) {
		driver.set(newValue);
	}

	// Reverse relations

}
