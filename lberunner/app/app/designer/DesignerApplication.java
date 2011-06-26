package app.designer;

import app.designer.data.entity.*;
import app.designer.data.instance.*;
import app.designer.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class DesignerApplication extends Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	private DesignerApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return ApplicationEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		MainFlow.INSTANCE,
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	@Override
	public Class<? extends CaseInstance> getCaseInstanceClass() {
		return ApplicationInstance.class;
	}

	@Override
	public String getName() {
		return "Designer";
	}
}
