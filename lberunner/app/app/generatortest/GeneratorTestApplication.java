package app.generatortest;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;

import app.generatortest.data.entity.CarinsuranceCaseEntity;
import app.generatortest.data.entity.DriverEntity;
import app.generatortest.data.instance.CarinsuranceCaseInstance;
import app.generatortest.flow.InsureXFlow;

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
