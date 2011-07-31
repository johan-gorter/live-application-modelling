package app.carinsurancetest;

import java.util.*;

import app.carinsurancetest.data.entity.*;
import app.carinsurancetest.data.instance.*;
import app.carinsurancetest.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class CarInsuranceTestApplication extends Application {

	public static final CarInsuranceTestApplication INSTANCE = new CarInsuranceTestApplication();
	
	private CarInsuranceTestApplication() {
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
		return CarinsuranceCaseInstance.class;
	}

	@Override
	public String getName() {
		return "CarInsuranceTest";
	}
}
