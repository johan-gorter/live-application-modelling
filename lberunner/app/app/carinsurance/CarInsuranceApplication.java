package app.carinsurance;

import java.util.*;

import app.carinsurance.entity.*;
import app.carinsurance.*;
import app.carinsurance.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

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
