package app.generatortest;

import java.util.*;

import app.generatortest.data.entity.*;
import app.generatortest.data.instance.*;
import app.generatortest.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class GeneratorTestApplication extends Application {

	public static final GeneratorTestApplication INSTANCE = new GeneratorTestApplication();
	
	protected GeneratorTestApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		InsureXFlow.INSTANCE,
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
		return "GeneratorTest";
	}
}
