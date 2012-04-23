package org.instantlogic.netty.manager;

import java.util.HashMap;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.interaction.Application;

public class ApplicationManager {

	public static final ApplicationManager[] applications = new ApplicationManager[]{
		new ApplicationManager(DesignerApplication.INSTANCE)
	};
	
	public static ApplicationManager getManager(String name) {
		for (ApplicationManager application: applications) {
			if (name.equals(application.getApplication().getName())) {
				return application;
			}
		}
		throw new RuntimeException("No such application: "+name);
	}

	private final Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	
	public ApplicationManager(Application application) {
		this.application = application;
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, caseId, application.getCaseEntity());
			activeCases.put(result.getCaseId(), result);
		}
		return result;
	}

	public Application getApplication() {
		return application;
	}
}
