package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;

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
	private Map<String, Instance> children;
	private Map<String, Instance> unmodifiableChildren = Collections.emptyMap();
	
	private TextTemplate staticDescription;

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
		Instance candidate = owner;
		while (candidate!=null) {
			if (Entity.extendsFrom(candidate.getInstanceEntity(), ofEntity)) return (T)candidate;
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
			this.unmodifiableChildren = Collections.unmodifiableMap(children);
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
		// TODO: allow 'migration' to another owner
		if (this.owner!=null && owner!=null) {
			throw new RuntimeException("This instance is already owned by "+this.owner);
		}
		this.owner = owner;
		if (owner==null) {
			remove();
		}
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

	public Map<String, Instance> getChildren() {
		return unmodifiableChildren;
	}
	
	public Instance getChild(String localId) {
		if (children==null) {
			throw new NoSuchElementException("Child "+localId);
		}
		Instance result = children.get(localId);
		if (result==null) {
			throw new NoSuchElementException("Child "+localId);
		}
		return result;
	}
	
	/**
	 * Clears all relations to other instances. Applies recursively to children
	 */
	private void remove() {
		if (children!=null) {
			Instance[] toRemove = children.values().toArray(new Instance[children.size()]);
			for(Instance instance: toRemove) { // depth-first
				instance.getMetadata().remove();
			}
		}
		for (Relation relation : getEntity().getRelations()) {
			if (!relation.isReadOnly() && relation.isMultivalue()) {
				RelationValues values = ((RelationValues)relation.get(instance));
				if (values.hasStoredValue()) { // No default
					for (int i=((Multi)values.getValue()).size();i>=0;i--)
					values.removeValue(i);
				}
			} else if (!relation.isReadOnly()) { // single value
				((RelationValue)relation.get(instance)).setValue(null);
			}
		}
		// TODO: clear reverse relations as well
	}

	/**
	 * Only used in static instances
	 */
	public TextTemplate getStaticDescription() {
		return staticDescription;
	}

	public void setStaticDescription(TextTemplate staticDescription) {
		this.staticDescription = staticDescription;
	}
}
