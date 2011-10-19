package lbe.designerbootstrap;


import java.util.Date;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.ButtonInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.DomainEntryInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.FlowEdgeInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowNodeBaseInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.HeaderInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;
import app.designer.data.instance.TextInstance;

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
	}

	private static void createCarinsurance() {
		ApplicationInstance applicationInstance = CarinsuranceBootstrapper.createCarinsurance();
		
		String json = CasePersister.gson.toJson(applicationInstance);
		//		System.out.println(json);
		applicationInstance = CasePersister.gson.fromJson(json, ApplicationInstance.class);
		
		CasePersister.INSTANCE.persist("carinsurance", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		CodeGenerator.generateApplication(applicationInstance);
	}

	public static void createDesigner() {
		ApplicationInstance applicationInstance = DesignerBootstrapper.createDesigner();

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CasePersister.INSTANCE.persist("designer", applicationInstance, (int)(System.currentTimeMillis()/1000));
		
		CodeGenerator.generateApplication(applicationInstance);
	}

}
