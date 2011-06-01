package lbe.instance;


public abstract class CaseInstance extends Instance {

	private long lastId;
	
	public CaseInstance() {
		super(null);
	}
	
	@Override
	public CaseInstance getCase() {
		return this;
	}
	
	public long nextId() {
		return ++lastId;
	}
}
