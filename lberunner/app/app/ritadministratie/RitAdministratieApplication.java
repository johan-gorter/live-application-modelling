package app.ritadministratie;

import java.util.*;

import app.ritadministratie.entity.*;
import app.ritadministratie.*;
import app.ritadministratie.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class RitAdministratieApplication extends Application {

	public static final RitAdministratieApplication INSTANCE = new RitAdministratieApplication();
	
	protected RitAdministratieApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return JaarEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	private static final Entity[] entities = new Entity[] {
		JaarEntity.INSTANCE,
		AutoEntity.INSTANCE,
		MaandEntity.INSTANCE,
		DagEntity.INSTANCE,
		RitEntity.INSTANCE,
		StandEntity.INSTANCE,
		TrajectEntity.INSTANCE,
		IjkingEntity.INSTANCE,
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
		return Jaar.class;
	}

	@Override
	public String getName() {
		return "RitAdministratie";
	}
}
