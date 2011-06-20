package lbe.instance;



public interface CaseInstance extends Instance {

	int getVersion();
	
	void setVersion(int version);
	
	long nextId();
	
}
