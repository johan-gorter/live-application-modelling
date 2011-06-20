
package app.carinsurance;

import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import app.carinsurance.flow.InsureFlow;
import app.carinsurancetest.data.entity.CarinsuranceCaseEntity;

public class CarinsuranceApplication extends Application {

	public static final CarinsuranceApplication INSTANCE = new CarinsuranceApplication();
	
	@Override
	public Entity getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		InsureFlow.INSTANCE
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}

}
