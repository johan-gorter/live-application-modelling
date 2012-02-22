package org.instantlogic.designer;

import org.instantlogic.designer.codegenerator.ApplicationGenerator;

public class ApplicationDesign extends AbstractApplicationDesign {
	
	private ApplicationGenerator applicationGenerator = new ApplicationGenerator(this);
	
	public ApplicationDesign() {
		
	}

	public ApplicationGenerator getApplicationGenerator() {
		return applicationGenerator;
	}
}
