package app.ritadministratie;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.model.CaseEntity;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;

import app.ritadministratie.entity.AutoEntity;
import app.ritadministratie.entity.DagEntity;
import app.ritadministratie.entity.IjkingEntity;
import app.ritadministratie.entity.JaarEntity;
import app.ritadministratie.entity.MaandEntity;
import app.ritadministratie.entity.RitEntity;
import app.ritadministratie.entity.StandEntity;
import app.ritadministratie.entity.TrajectEntity;

public class RitAdministratieApplication extends Application {

	public static final RitAdministratieApplication INSTANCE = new RitAdministratieApplication();
	
	protected RitAdministratieApplication() {
	}
	
	@Override
	public CaseEntity getCaseModel() {
		return JaarEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
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
