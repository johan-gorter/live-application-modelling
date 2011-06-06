package lbe.instance;

import lbe.instance.CaseInstance;
import lbe.model.Entity;

public interface Instance {
	
	CaseInstance getCase();
	
	long getInstanceId();
	
	Entity getModel();
	
}
