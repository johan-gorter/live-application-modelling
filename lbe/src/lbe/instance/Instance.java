package lbe.instance;

import lbe.model.EntityModel;

public abstract class Instance {
	
	private final Instance caseInstance;
	
	public Instance(Instance caseInstance) {
		this.caseInstance = caseInstance;
	}
	
	public Instance getCase() {
		return caseInstance;
	}
	
	public abstract EntityModel getModel();

}
