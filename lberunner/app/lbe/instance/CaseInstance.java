package lbe.instance;

import lbe.model.Application;



public interface CaseInstance extends Instance {

	Application getApplication();
	
	int getVersion();
	
	void setVersion(int version);
	
	/**
	 * 
	 * @param instance
	 * @param id Only used while deserializing. Set to 0 to register a new Instance.
	 * @return
	 */
	long registerInstance(Instance instance, long id);
	
	Instance getInstanceById(long id);
	
}
