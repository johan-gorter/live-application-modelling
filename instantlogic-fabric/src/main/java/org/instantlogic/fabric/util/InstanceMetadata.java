package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

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
	private final Entity<? extends Instance> entity;
	private String uniqueId;
	private Instance owner = null;
	private List<GlobalValueChangeListener> globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	// When this value is the same as globalValueChangeListeners, copy globalValueChangeListeners on write and clear this field.
	private List<GlobalValueChangeListener> iteratingGlobalValueChangeListeners = null; 
	// Only available on the top instance, instances with an owner get the registry from the top instance (TODO: cache and invalidate for performance)
	private CaseAdministration caseAdministration; 
	
	private String localId="0";
	private int lastChildId=0;
	private Map<String, Instance> children;
	private Map<String, Instance> unmodifiableChildren = Collections.emptyMap();
	
	private TextTemplate staticDescription;
	private String staticName;

	public InstanceMetadata(Instance instance, Entity<? extends Instance> entity) {
		this.instance = instance;
		this.entity = entity;
	}

	private static class GlobalValueChangeListener {
		ValueChangeObserver listener;
		boolean alsoForOwnedInstances;
	}
	
	
	public CaseAdministration getCaseAdministration() {
		if (caseAdministration==null) {
			if (owner!=null) {
				return owner.getMetadata().getCaseAdministration();
			} else {
				caseAdministration = new CaseAdministration(instance);
			}
		}
		return caseAdministration;
	}
	
	@Deprecated //Use getUniqueId
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
			if (Entity.extendsFrom(candidate.getMetadata().getEntity(), ofEntity)) return (T)candidate;
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
		String childLocalId = (Character.toUpperCase(instance.getMetadata().getEntity().getName().charAt(0)))+""+(++lastChildId);
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
		if (this.isStatic()) throw new RuntimeException("Static instances cannot be owned by a case, they are global");
		if (this.owner!=null && owner!=null) {
			// 'Migration' to another owner is not allowed, because this would change instance Id's
			throw new RuntimeException("This instance is already owned by "+this.owner);
		}
		if (this.owner!=null) {
			this.caseAdministration = this.owner.getMetadata().getCaseAdministration(); // temporary
		}
		this.owner = owner;
		
		if (owner==null) {
			clearRelationsAfterSplit(this.instance);
			this.caseAdministration = null;
			this.localId="0";
		} else {
			this.caseAdministration = null; // Fallthrough to the owner
			this.localId = localId;
			registerUniqueIdsWithCaseAdministration(getCaseAdministration());
		}
	}
	
	private void registerUniqueIdsWithCaseAdministration(CaseAdministration newCaseAdministration) {
		if (uniqueId!=null) {
			newCaseAdministration.rememberInstanceWithUniqueId(uniqueId, instance);
		}
		if (children!=null) {
			for(Instance instance: children.values()) { // depth-first
				instance.getMetadata().registerUniqueIdsWithCaseAdministration(newCaseAdministration);
			}
		}
	}

	public Entity<?> getEntity() {
		return entity;
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
	 * Clears all relations to instances in other cases. Applies recursively to children. (getCaseAdministration() still refers the old case now)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void clearRelationsAfterSplit(Instance newCase) {
		if (uniqueId!=null) {
			getCaseAdministration().forgetInstanceWithUniqueId(uniqueId);
		}
		if (children!=null) {
			for(Instance instance: children.values()) { // depth-first
				instance.getMetadata().clearRelationsAfterSplit(newCase);
			}
		}
		for (Relation relation : getEntity().getRelations()) {
			if (!relation.isReadOnly() && !relation.isOwner()) { 
				if (relation.isMultivalue()) {
					RelationValues values = ((RelationValues)relation.get(instance));
					if (values.hasStoredValue()) { // No default
						Multi<? extends Instance> multi = (Multi<? extends Instance>)values.getValue();
						for (int i=multi.size()-1;i>=0;i--) {
							if (multi.get(i).getMetadata().getCase()!=newCase) {
								values.removeValue(i);
							}
						}
					}
				} else { // single value
					ReadOnlyAttributeValue value = relation.get(instance);
					if (value.hasStoredValue()) { // No default
						if (((Instance)value.getValue()).getMetadata().getCase()!=newCase) {
							((RelationValue)value).setValue(null);
						}
					}
				}
			}
		}
		for (Relation relation : getEntity().getReverseRelations()) {
			if (!relation.getReverseRelation().isOwner()) {
				if (relation.isMultivalue()) {
					RelationValues values = ((RelationValues)relation.get(instance));
					Multi<? extends Instance> multi = (Multi<? extends Instance>)values.getValue();
					for (int i=multi.size()-1;i>=0;i--) {
						if (multi.get(i).getMetadata().getCase()!=newCase) {
							values.removeValue(i);
						}
					}
				} else { // single value
					ReadOnlyAttributeValue value = relation.get(instance);
					if (value.getValue()!=null) {
						if (((Instance)value.getValue()).getMetadata().getCase()!=newCase) {
							((RelationValue)value).setValue(null);
						}
					}
				}
			}
		}
	}

	public Instance getCase() {
		Instance result = instance;
		while (result.getMetadata().getInstanceOwner()!=null) {
			result = result.getMetadata().getInstanceOwner();
		}
		return result;
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

	public void makeStatic(String name) {
		this.staticName = name;
	}
	
	public boolean isStatic() {
		return this.staticName!=null;
	}

	public String getStaticName() {
		return staticName;
	}
	
	public void initUniqueId(String uniqueId) {
		if (this.uniqueId!=null) {
			throw new RuntimeException("UniqueId was already initialized and cannot be changed");
		}
		getCaseAdministration().rememberInstanceWithUniqueId(this.uniqueId, this.instance);
		this.uniqueId = uniqueId;
	}

	public String getUniqueId() {
		if (this.uniqueId==null) {
			this.uniqueId = UUID.randomUUID().toString();
			getCaseAdministration().rememberInstanceWithUniqueId(this.uniqueId, this.instance);
		}
		return uniqueId;
	}
}
