package lbe.instance.impl;

import lbe.instance.CaseInstance;
import lbe.model.Entity;

public class SimpleCaseInstance extends SimpleInstance implements CaseInstance {

	private long lastId;
	private int version;
	
	public SimpleCaseInstance(Entity entity) {
		super(null, entity);
	}
	
	@Override
	public CaseInstance getCase() {
		return this;
	}
	
	public long nextId() {
		return ++lastId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
