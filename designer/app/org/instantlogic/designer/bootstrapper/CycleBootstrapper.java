package org.instantlogic.designer.bootstrapper;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.bootstrapper.Bootstrapper.RelationType;

public class CycleBootstrapper extends BootstrapperUtil {

	public static ApplicationDesign createCycle() {

		// Case
		applicationDesign = new ApplicationDesign();
		applicationDesign.setName("Cycle");
		
		applicationDesign.setRootPackageName("org.instantlogic.cycle");
		applicationDesign.setSourcePath("/prive/live-business-engineering/designer-generated/app");

		// Entities
		EntityDesign planning = createEntity("Planning", null);
		EntityDesign employee = createEntity("Employee", null);
		EntityDesign project = createEntity("Project", null);

		// Relations
		createRelation(planning, "employees", RelationType.OneToManyAggregation, "planning", employee);
		createRelation(planning, "projects", RelationType.OneToManyAggregation, "planning", project);
		
		createRelation(employee, "contributesOn", RelationType.ManyToMany, "contributers", project);
		createRelation(project, "lead", RelationType.ManyToZeroOrOne, "leads", employee);
		
		applicationDesign.setCaseEntity(planning);
		return applicationDesign;
	}
	
}
