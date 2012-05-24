package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;

public class InstanceMetadata {

	private final Instance instance;
	private Instance owner = null;
	private List<GlobalValueChangeListener> globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	// When this value is the same as globalValueChangeListeners, copy globalValueChangeListeners on write and clear this field.
	private List<GlobalValueChangeListener> iteratingGlobalValueChangeListeners = null; 
	// Only available on the top instance, instances with an owner get the registry from the top instance (TODO: cache and invalidate for performance)
	private CaseAdministration instanceRegistry; 
	
	private String localId="0";
	private int lastChildId=0;
	private HashMap<String, Instance> children;
	

	public InstanceMetadata(Instance instance) {
		this.instance = instance;
	}

	private static class GlobalValueChangeListener {
		ValueChangeObserver listener;
		boolean alsoForOwnedInstances;
	}
	
	
	public CaseAdministration getCaseAdministration() {
		if (instanceRegistry==null) {
			if (owner!=null) {
				return owner.getMetadata().getCaseAdministration();
			} else {
				instanceRegistry = new CaseAdministration(instance);
			}
		}
		return instanceRegistry;
	}
	
	public void getInstanceId(StringBuilder builder) {
		if (owner!=null) {
			owner.getMetadata().getInstanceId(builder);
			if (builder.length()==1) { // "0", the id of the case instance
				builder.setLength(0);
			}
		}
		builder.append(localId);
	}
	
	public String getInstanceLocalId() {
		return localId;
	}
	
	public String getInstanceId() {
		StringBuilder builder = new StringBuilder();
		getInstanceId(builder);
		return builder.toString();
	}
	
	public void addGlobalValueChangeListener(ValueChangeObserver listener, boolean alsoForOwnedInstances) {
		GlobalValueChangeListener gvcl = new GlobalValueChangeListener();
		gvcl.listener = listener;
		gvcl.alsoForOwnedInstances = alsoForOwnedInstances;
		copyGlobalValueChangeListenersIfNeeded();
		globalValueChangeListeners.add(gvcl);
	}
	
	private void copyGlobalValueChangeListenersIfNeeded() {
		if (iteratingGlobalValueChangeListeners==globalValueChangeListeners) {
			globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>(globalValueChangeListeners);
		}
	}

	public void removeGlobalValueChangeListener(ValueChangeObserver listener) {
		copyGlobalValueChangeListenersIfNeeded();
		Iterator<GlobalValueChangeListener> iterator = globalValueChangeListeners.iterator();
		while (iterator.hasNext()) {
			GlobalValueChangeListener next = iterator.next();
			if (next.listener==listener) {
				iterator.remove();
				return;
			}
		}
		throw new NoSuchElementException("GlobalValueChangeListener "+listener);
	}
	
	public void fireValueChanged(ValueChangeEvent event, boolean fromSelf) {
		boolean clearIteratingOnExit = false;
		if (iteratingGlobalValueChangeListeners != globalValueChangeListeners) {
			iteratingGlobalValueChangeListeners = globalValueChangeListeners;
			clearIteratingOnExit = true;
		}
		List<GlobalValueChangeListener> iterating = iteratingGlobalValueChangeListeners;
		ListIterator<GlobalValueChangeListener> iterator = iterating.listIterator(iterating.size());
		try {
			while (iterator.hasPrevious()) {
				GlobalValueChangeListener listener = iterator.previous();
				if (listener.alsoForOwnedInstances || fromSelf) {
					listener.listener.valueChanged(event);
				}
			}
			if (owner!=null) {
				owner.getMetadata().fireValueChanged(event, false);
			}
		} finally {
			if (clearIteratingOnExit && iteratingGlobalValueChangeListeners == iterating) {
				iteratingGlobalValueChangeListeners = null;
			}
		}
	}
	

	public Instance getInstanceOwner() {
		return owner;
	}
	
	/**
	 * Travels down the owners until an owner of the specified entity (or subclass) is found
	 * @param ofEntity The desired entity
	 * @return an instance of the desired entity or null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Instance> T getInstanceOwner(Entity<T> ofEntity) {
		if (ofEntity==null) throw new IllegalArgumentException();
		Class<T> instanceClass = ofEntity.getInstanceClass();
		Instance candidate = owner;
		while (candidate!=null) {
			if (Entity.extendsFrom(candidate.getInstanceEntity(), ofEntity)) return (T)candidate;
//			if (instanceClass.isAssignableFrom(candidate.getClass())) return (T)candidate;  // Causes problems with GWT
			candidate = candidate.getMetadata().getInstanceOwner();
		}
		return null;
	}
	
	/**
	 * Registers this as the owner of instance.
	 * @param instance the owned instance.
	 */
	public void adopt(Instance instance) {
		if (children==null) {
			children = new HashMap<String, Instance>();
		}
		String childLocalId = (Character.toUpperCase(instance.getInstanceEntity().getName().charAt(0)))+""+(++lastChildId);
		children.put(childLocalId, instance);
		instance.getMetadata().registerOwner(this.instance, childLocalId);
	}
	
	/**
	 * Opposite of adopt, clears the owner of instance
	 * @param instance
	 */
	public void reject(Instance instance) {
		Instance found = children.remove(instance.getMetadata().getInstanceLocalId());
		if (found!=instance) throw new RuntimeException("This instance was not adopted: "+instance);
		instance.getMetadata().registerOwner(null, null);
	}
	
	protected void registerOwner(Instance owner, String localId) {
		if (this.owner!=null && owner!=null) {
			throw new RuntimeException("This instance is already owned by "+this.owner);
		}
		this.owner = owner;
		this.localId = owner==null?"0":localId;
		this.instanceRegistry = null;
	}
	
	public Entity<?> getEntity() {
		return instance.getInstanceEntity();
	}
	
	@Override
	public String toString() {
		return "InstanceMetadata("+instance.toString()+")";
	}
}
