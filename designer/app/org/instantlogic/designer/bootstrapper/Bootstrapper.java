package org.instantlogic.designer.bootstrapper;

import org.instantlogic.designer.ApplicationDesign;



public class Bootstrapper {

	public enum RelationType {
		OneToZeroOrOne, 
		OneToZeroOrOneAggregation, 
		OneToOneAggregation, 
		OneToMany, 
		OneToManyAggregation, 
		ManyToZeroOrOne, 
		ManyToMany
	}
	
	public static void main(String[] args) {
//		createCarinsurance();
//		createDesigner();
//		CycleBootstrapper.createCycle().getApplicationGenerator().generateJavaCode();
//		PeriodBootstrapper.createPeriod().getApplicationGenerator().generateJavaCode();
	}

	public static void createDesigner() {
		ApplicationDesign applicationInstance = DesignerBootstrapper.createDesigner();

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
//		CasePersister.INSTANCE.persist("designer", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		//new ApplicationGenerator(applicationInstance).update(false);

//		applicationInstance.afterLoading();
		
		applicationInstance.getApplicationGenerator().generateJavaCode();
		
//		applicationInstance.afterSubmit();
	}

	
}
