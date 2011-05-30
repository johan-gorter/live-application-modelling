package lbe.instance;

import lbe.model.Entity;

public abstract class Instance {
	
	private final CaseInstance caseInstance;
	
	private final long id;
	
	public Instance(CaseInstance caseInstance) {
		this.caseInstance = caseInstance;
		if (caseInstance!=null) {
			this.id = caseInstance.nextId();
		} else {
			this.id = 0; // This means we are the caseInstance
		}
	}
	
	public CaseInstance getCase() {
		return caseInstance;
	}
	
	public abstract Entity getModel();

	public long getInstanceId() {
		return id;
	}

}
