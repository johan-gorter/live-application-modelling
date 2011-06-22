
package app.carinsurance;

import lbe.instance.CaseInstance;
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

	@Override
	public Class<? extends CaseInstance> getCaseInstanceClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
