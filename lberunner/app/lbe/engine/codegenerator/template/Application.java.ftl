package app.${appname};

import app.${appname}.data.entity.*;
import app.${appname}.flow.*;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class ${name}Application extends Application {

	public static final ${name}Application INSTANCE = new ${name}Application();
	
	private ${name}Application() {
	}
	
	@Override
	public Entity getCaseModel() {
		return ${caseEntity}Entity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
	<#list exposedFlows as exposedFlow>
		${exposedFlow}Flow.INSTANCE,
	</#list>
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}

}
