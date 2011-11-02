package app.carinsurance.data.instance;

import java.util.List;

import app.carinsurance.*;
import app.carinsurance.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class CarinsuranceCaseInstance 
	extends SimpleCaseInstance 
	implements Instance {

	public CarinsuranceCaseInstance() {
		super(CarinsuranceCaseEntity.INSTANCE, CarInsuranceApplication.INSTANCE);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<CarinsuranceCaseInstance, DriverInstance> driver
		= createRelationValue(CarinsuranceCaseEntity.driver);

	// Reverse relations

}
