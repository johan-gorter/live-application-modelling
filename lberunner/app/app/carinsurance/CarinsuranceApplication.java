package app.carinsurance;

import app.carinsurance.entity.CarinsuranceCaseEntity;
import app.carinsurance.flow.InsureFlow;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class CarinsuranceApplication extends Application {

	public static final CarinsuranceApplication INSTANCE = new CarinsuranceApplication();
	
	@Override
	public Entity getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {InsureFlow.INSTANCE};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}

}
