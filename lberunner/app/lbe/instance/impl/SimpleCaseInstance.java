package lbe.instance.impl;

import java.util.WeakHashMap;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;

public class SimpleCaseInstance extends SimpleInstance implements CaseInstance {

	private long lastId;
	private int version;
	
	private WeakHashMap<Long, Instance> instances = new WeakHashMap<Long, Instance>();
	
	public SimpleCaseInstance(Entity entity) {
		super(null, entity);
	}
	
	@Override
	public CaseInstance getCase() {
		return this;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public long registerInstance(Instance instance) {
		long id = ++lastId;
		instances.put(id, instance);
		return id;
	}

	@Override
	public Instance getInstanceById(long id) {
		return instances.get(id);
	}

}
