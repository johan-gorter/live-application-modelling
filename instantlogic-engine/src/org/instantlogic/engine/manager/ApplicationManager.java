package org.instantlogic.engine.manager;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.interaction.Application;

public class ApplicationManager {

	private static Map<String, ApplicationManager> applicationManagers = new HashMap<String, ApplicationManager>();
	
	public static void registerApplication(Application application) {
		applicationManagers.put(application.getName(), new ApplicationManager(application));
	}
	
	public static ApplicationManager getManager(String name) {
		ApplicationManager result = applicationManagers.get(name);
		if (result==null) {
			throw new RuntimeException("No such application: "+name);
		}
		return result;
	}

	private final Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	
	public ApplicationManager(Application application) {
		this.application = application;
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, caseId);
			activeCases.put(result.getCaseId(), result);
		}
		return result;
	}

	public Application getApplication() {
		return application;
	}
}
