
package app.carinsurance;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import app.carinsurance.entity.DriverEntity;
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

	private static final Entity[] entities = new Entity[] {
		app.carinsurance.entity.CarinsuranceCaseEntity.INSTANCE,
		DriverEntity.INSTANCE
	};
	private static final SortedMap<String, Entity> entityMap = new TreeMap<String, Entity>();
	static {
		for (Entity entity:entities) {
			entityMap.put(entity.getName(), entity);
		}
	}
	@Override
	public SortedMap<String, Entity> getEntities() {
		return entityMap;
	}
}
