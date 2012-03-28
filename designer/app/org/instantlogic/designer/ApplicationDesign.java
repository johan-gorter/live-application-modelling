package org.instantlogic.designer;

import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;

public class ApplicationDesign extends AbstractApplicationDesign {
	
	private ApplicationGenerator applicationGenerator = new ApplicationGenerator(this);
	
	public ApplicationDesign() {
		
	}

	public ApplicationGenerator getApplicationGenerator() {
		return applicationGenerator;
	}
	
	/**
	 * Registers every entity reachable from caseEntity to application.entities. Also calls init() on every entity.
	 */
	protected void init() {
		getCaseEntity().registerApplication(this);
		for (EntityDesign entity:getEntities()) {
			entity.init();
		}
	}
}
