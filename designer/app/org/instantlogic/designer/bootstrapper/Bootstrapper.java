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
		createDesigner();
//		createRitadministratie();
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

//	private static void createCarinsurance() {
//		ApplicationDesign applicationInstance = CarinsuranceBootstrapper.createCarinsurance();
//		
//		String json = CasePersister.gson.toJson(applicationInstance);
//		//		System.out.println(json);
//		applicationInstance = CasePersister.gson.fromJson(json, ApplicationDesignCustomization.class);
//		
//		CasePersister.INSTANCE.persist("carinsurance", applicationInstance, (int)(System.currentTimeMillis()/1000));
//		
//		applicationInstance.afterLoading();
//		
//		applicationInstance.getApplicationGenerator().setMustRegenerate();
//		
//		applicationInstance.afterSubmit();
//		
//		//new ApplicationGenerator(applicationInstance).update(false);
//	}
//
//	private static void createRitadministratie() {
//		ApplicationDesignCustomization applicationInstance = RitAdministratieBootstrapper.createRitAdministratie();
//		
//		String json = CasePersister.gson.toJson(applicationInstance);
//		//		System.out.println(json);
//		applicationInstance = CasePersister.gson.fromJson(json, ApplicationDesignCustomization.class);
//		
//		CasePersister.INSTANCE.persist("ritAdministratie", applicationInstance, (int)(System.currentTimeMillis()/1000));
//		
//		applicationInstance.afterLoading();
//		
//		applicationInstance.getApplicationGenerator().setMustRegenerate();
//		
//		applicationInstance.afterSubmit();
//	}
	
}
