package lbe.designerbootstrap;


import lbe.engine.CasePersister;
import custom.designer.ApplicationDesignCustomization;

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
		createRitadministratie();
	}

	private static void createCarinsurance() {
		ApplicationDesignCustomization applicationInstance = CarinsuranceBootstrapper.createCarinsurance();
		
		String json = CasePersister.gson.toJson(applicationInstance);
		//		System.out.println(json);
		applicationInstance = CasePersister.gson.fromJson(json, ApplicationDesignCustomization.class);
		
		CasePersister.INSTANCE.persist("carinsurance", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		applicationInstance.afterLoading();
		
		applicationInstance.getApplicationGenerator().setMustRegenerate();
		
		applicationInstance.afterSubmit();
		
		//new ApplicationGenerator(applicationInstance).update(false);
	}

	public static void createDesigner() {
		ApplicationDesignCustomization applicationInstance = DesignerBootstrapper.createDesigner();

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CasePersister.INSTANCE.persist("designer", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		//new ApplicationGenerator(applicationInstance).update(false);

		applicationInstance.afterLoading();
		
		applicationInstance.getApplicationGenerator().setMustRegenerate();
		
		applicationInstance.afterSubmit();
	}

	private static void createRitadministratie() {
		ApplicationDesignCustomization applicationInstance = RitAdministratieBootstrapper.createRitAdministratie();
		
		String json = CasePersister.gson.toJson(applicationInstance);
		//		System.out.println(json);
		applicationInstance = CasePersister.gson.fromJson(json, ApplicationDesignCustomization.class);
		
		CasePersister.INSTANCE.persist("ritAdministratie", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		applicationInstance.afterLoading();
		
		applicationInstance.getApplicationGenerator().setMustRegenerate();
		
		applicationInstance.afterSubmit();
	}
	
}
