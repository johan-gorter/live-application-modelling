package lbe.instance.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.WeakHashMap;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.Observations;
import lbe.instance.value.ReadOnlyAttributeValue;
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

	@Override
	public void registerObservation(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
		if (currentObservations!=null) {
			currentObservations.add(attributeValueObserved);
		}
	}
	
	private Deque<Observations> observationsStack = new ArrayDeque<Observations>();
	private Observations currentObservations = null;
	
	public void startRecordingObservations() {
		if (currentObservations!=null) {
			observationsStack.push(currentObservations);
		}
		currentObservations = new Observations();
	}

	public Observations stopRecordingObservations() {
		Observations result = currentObservations;
		if (result==null) throw new IllegalStateException();
		if (observationsStack.size()>0) {
			currentObservations = observationsStack.pop();
		} else {
			currentObservations = null;
		}
		return result;
	}
	
	public void afterLoading() {
	}
	
	public void afterSubmit() {
	}
}
