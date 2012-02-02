package org.instantlogic.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.value.ReadOnlyAttributeValue;

public class InstanceRegistry {

	//TODO: either use weakrefhashmap or implement removal of instances which lose their owner
	private HashMap<Long, Instance<?>> instances = new HashMap<Long, Instance<?>>();
	
	private long lastId;
	private long version;
	
	public InstanceRegistry(CaseInstance<? extends CaseInstance<?>> caseInstance) {
		instances.put(0l, caseInstance);
	}
	
	/**
	 * 
	 * @param instance
	 * @param id Only used while deserializing. Set to 0 to register a new Instance.
	 * @return
	 */
	public long registerInstance(Instance<?> instance, long id) {
		if (id==0) {
			id = ++lastId;
		} else {
			lastId = Math.max(lastId, id);
		}
		instances.put(id, instance);
		return id;
	}

	public Instance<?> getInstanceById(long id) {
		return instances.get(id);
	}

	public void registerObservation(ReadOnlyAttributeValue<? extends Instance<?>, ? extends Object> attributeValueObserved) {
		if (currentObservations!=null) {
			currentObservations.add(attributeValueObserved);
		}
	}
	
	private List<Observations> observationsStack = new ArrayList<Observations>();
	private Observations currentObservations = null;
	
	public void startRecordingObservations() {
		if (currentObservations!=null) {
			observationsStack.add(currentObservations);
		}
		currentObservations = new Observations();
	}

	public Observations stopRecordingObservations() {
		Observations result = currentObservations;
		if (result==null) throw new IllegalStateException();
		if (observationsStack.size()>0) {
			// pop
			currentObservations = observationsStack.get(observationsStack.size()-1);
			observationsStack.remove(observationsStack.size()-1);
		} else {
			currentObservations = null;
		}
		return result;
	}
	
	public void afterLoading() {
	}
	
	public void afterSubmit() {
	}

	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	

}
