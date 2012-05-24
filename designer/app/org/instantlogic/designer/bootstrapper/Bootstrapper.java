package org.instantlogic.designer.bootstrapper;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.generatorgenerator.GeneratorGenerator;



public class Bootstrapper {

	
	public static void main(String[] args) {
//		createCarinsurance();
		createDesigner();
//		CycleBootstrapper.createCycle().getApplicationGenerator().generateJavaCode();
//		PeriodBootstrapper.createPeriod().getApplicationGenerator().generateJavaCode();
	}

	public static void createDesigner() {
		ApplicationDesign applicationInstance = DesignerBootstrapper.createDesigner();

		new GeneratorGenerator(applicationInstance, "../nextdesigner-generator/src/org/instantlogic/designer").generate();
		
//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
//		CasePersister.INSTANCE.persist("designer", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
//		applicationInstance.getApplicationGenerator().generateJavaCode();
	}

	
}
