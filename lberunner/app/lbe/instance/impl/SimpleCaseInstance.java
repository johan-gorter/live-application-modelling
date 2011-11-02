package lbe.instance.impl;

import java.util.WeakHashMap;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Application;
import lbe.model.Entity;

public class SimpleCaseInstance extends SimpleInstance implements CaseInstance {

	private long lastId;
	private int version;
	private final Application application;
	
	private WeakHashMap<Long, Instance> instances = new WeakHashMap<Long, Instance>();
	
	public SimpleCaseInstance(Entity entity, Application application) {
		super(null, entity, 0);
		this.application = application;
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
	public long registerInstance(Instance instance, long id) {
		if (id==0) {
			id = ++lastId;
		} else {
			lastId = Math.max(lastId, id);
		}
		instances.put(id, instance);
		return id;
	}

	@Override
	public Instance getInstanceById(long id) {
		if (id==0l) return this;
		return instances.get(id);
	}

	@Override
	public Application getApplication() {
		return application;
	}

}
