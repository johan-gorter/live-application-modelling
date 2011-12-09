package app.carinsurance;

import java.util.List;

import app.carinsurance.*;
import app.carinsurance.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

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
