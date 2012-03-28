package org.instantlogic.designer.bootstrapper;


import java.util.Date;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;

public class PeriodBootstrapper extends BootstrapperUtil {

	public static ApplicationDesign createPeriod() {

		// Case
		applicationDesign = new ApplicationDesign();
		applicationDesign.setName("PeriodApplication");
		
		applicationDesign.setRootPackageName("org.instantlogic.period");
		applicationDesign.setSourcePath("/prive/live-business-engineering/designer-generated/app");

		// Entities
		EntityDesign period = createEntity("Period", null);

		// Relations
		createAttribute(period, "from", Date.class);
		createAttribute(period, "to", Date.class);
		createAttribute(period, "daysBetween", Integer.class);
		
		applicationDesign.setCaseEntity(period);
		return applicationDesign;
	}
	
}
