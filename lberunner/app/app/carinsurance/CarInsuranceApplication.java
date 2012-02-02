package app.carinsurance;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;

import app.carinsurance.entity.CarinsuranceCaseEntity;
import app.carinsurance.entity.DriverEntity;
import app.carinsurance.flow.InsureFlow;

public class CarInsuranceApplication extends Application {

	public static final CarInsuranceApplication INSTANCE = new CarInsuranceApplication();
	
	protected CarInsuranceApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		InsureFlow.INSTANCE,
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	private static final Entity[] entities = new Entity[] {
		CarinsuranceCaseEntity.INSTANCE,
		DriverEntity.INSTANCE,
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
	
	
	@Override
	public Class<? extends CaseInstance> getCaseInstanceClass() {
		return CarinsuranceCase.class;
	}

	@Override
	public String getName() {
		return "CarInsurance";
	}
}
