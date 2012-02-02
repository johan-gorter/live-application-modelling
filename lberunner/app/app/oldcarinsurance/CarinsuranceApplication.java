
package app.oldcarinsurance;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;

import app.oldcarinsurance.entity.CarinsuranceCaseEntity;
import app.oldcarinsurance.entity.DriverEntity;
import app.oldcarinsurance.flow.InsureFlow;

public class CarinsuranceApplication extends Application {

	public static final CarinsuranceApplication INSTANCE = new CarinsuranceApplication();
	
	@Override
	public CaseEntity getCaseModel() {
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
