package app.generatortest.data.instance;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleCaseInstance;
import org.instantlogic.fabric.value.RelationValue;

import app.generatortest.GeneratorTestApplication;
import app.generatortest.data.entity.CarinsuranceCaseEntity;

public class CarinsuranceCaseInstance 
	extends SimpleCaseInstance 
	implements Instance {

	public CarinsuranceCaseInstance() {
		super(CarinsuranceCaseEntity.INSTANCE, GeneratorTestApplication.INSTANCE);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<CarinsuranceCaseInstance, DriverInstance> driver
		= createRelationValue(CarinsuranceCaseEntity.driver);

	// Reverse relations

}
