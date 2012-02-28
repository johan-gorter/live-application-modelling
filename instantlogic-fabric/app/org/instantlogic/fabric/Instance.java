package org.instantlogic.fabric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.InstanceAdministration;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.impl.AttributeValueImpl;
import org.instantlogic.fabric.value.impl.AttributeValuesImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyAttributeValueImpl;
import org.instantlogic.fabric.value.impl.ReadOnlyRelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValueImpl;
import org.instantlogic.fabric.value.impl.RelationValuesImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValueImpl;
import org.instantlogic.fabric.value.impl.ReverseRelationValuesImpl;

/**
 * Can be compared to a class, only more powerful.
 * 
 * Note that an instance should always have an owner. the root of this owner hierarchy is called the case.
 */
public abstract class Instance {
	
	private static class GlobalValueChangeListener {
		ValueChangeObserver listener;
		boolean alsoForOwnedInstances;
		boolean permanent;
	}
	
	private List<GlobalValueChangeListener> tempGlobalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	private List<GlobalValueChangeListener> globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	
	private Instance owner = null;
	
	public abstract Entity<?> getInstanceEntity();
	
	// Only available on the top instance, instances with an owner get the registry from the top instance (TODO: cache and invalidate for performance)
	private InstanceAdministration instanceRegistry; 
	
	private String localId="0";
	private int lastChildId=0;
	private HashMap<String, Instance> children;
	
	protected Instance() {
	}
	
	public InstanceAdministration getInstanceAdministration() {
		if (instanceRegistry==null) {
			if (owner!=null) {
				return owner.getInstanceAdministration();
			} else {
				instanceRegistry = new InstanceAdministration(this);
			}
		}
		return instanceRegistry;
	}
	
	public String getInstanceId() {
		StringBuilder builder = new StringBuilder();
		getInstanceId(builder);
		return builder.toString();
	}
	
	public void getInstanceId(StringBuilder builder) {
		if (owner!=null) {
			owner.getInstanceId(builder);
			if (builder.length()==1 && builder.toString().equals("0")) {
				builder.setLength(0);
			} else {
				builder.append("-");
			}
		}
		builder.append(localId);
	}
	
	public String getInstanceLocalId() {
		return localId;
	}
	
	/**
	 * Registers this as the owner of instance.
	 * @param instance the owned instance.
	 */
	public void adopt(Instance instance) {
		if (children==null) {
			children = new HashMap<String, Instance>();
		}
		String childLocalId = ""+(++lastChildId);
		children.put(childLocalId, instance);
		instance.registerOwner(this, childLocalId);
	}
	
	/**
	 * Opposite of adopt, clears the owner of instance
	 * @param instance
	 */
	public void reject(Instance instance) {
		Instance found = children.remove(instance.getInstanceLocalId());
		if (found!=instance) throw new RuntimeException("This instance was not adopted: "+instance);
		instance.registerOwner(null, null);
	}
	
	protected void registerOwner(Instance owner, String localId) {
		if (this.owner!=null && owner!=null) {
			throw new RuntimeException("This instance is already owned by "+this.owner);
		}
		this.owner = owner;
		this.localId = owner==null?"0":localId;
		this.instanceRegistry = null;
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> ReadOnlyAttributeValueImpl<I, Value> createReadOnlyAttributeValue(Attribute<I, Value, Value> attribute) {
		return new ReadOnlyAttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValue<I, Value> createAttributeValue(Attribute<I, Value, Value> attribute) {
		return new AttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	@SuppressWarnings("unchecked")
	protected<Value extends Object, I extends Instance> AttributeValues<I, Value> createAttributeValues(Attribute<I, Multi<Value>, Value> attribute) {
		return new AttributeValuesImpl<I, Value>((I)this, attribute);
	}

	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> ReadOnlyRelationValue<I, To> createReadOnlyRelationValue(Relation<I, To, To> relation) {
		return new ReadOnlyRelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValue<I, To> createRelationValue(Relation<I, To, To> relation) {
		return new RelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> RelationValues<I, To> createRelationValues(Relation<I, Multi<To>, To> relation) {
		return new RelationValuesImpl<I, To>((I)this, relation);
	}

	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> ReadOnlyRelationValue<I, To> createReverseRelationValue(Relation<I, To, To> relation) {
		return new ReverseRelationValueImpl<I, To>((I)this, relation);
	}
	
	@SuppressWarnings("unchecked")
	protected<To extends Instance, I extends Instance> ReadOnlyRelationValues<I, To> createReverseRelationValues(Relation<I, Multi<To>, To> relation) {
		return new ReverseRelationValuesImpl<I, To>((I)this, relation);
	}
	
	public String getName() {
		return null;
	}
	
	@Override
	public String toString() {
		String name = getName();
		if (name==null) {
			name="";
		} else {
			name="("+name+")";
		}
		StringBuilder instanceId = new StringBuilder();
		getInstanceId(instanceId);
		return getInstanceEntity().toString()+"#"+instanceId+name;
	}
	
	public void addGlobalValueChangeListener(ValueChangeObserver listener, boolean alsoForOwnedInstances, boolean permanent) {
		GlobalValueChangeListener gvcl = new GlobalValueChangeListener();
		gvcl.listener = listener;
		gvcl.permanent = permanent;
		gvcl.alsoForOwnedInstances = alsoForOwnedInstances;
		globalValueChangeListeners.add(gvcl);
	}
	
	public void removeGlobalValueChangeListener(ValueChangeObserver listener) {
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
		List<GlobalValueChangeListener> oldTemp = tempGlobalValueChangeListeners;
		tempGlobalValueChangeListeners = globalValueChangeListeners;
		globalValueChangeListeners = oldTemp;
		for (GlobalValueChangeListener listener: tempGlobalValueChangeListeners) {
			boolean reAdd = true;
			if (listener.alsoForOwnedInstances || fromSelf) {
				listener.listener.valueChanged(event);
				reAdd = listener.permanent;
			}
			if (reAdd) {
				globalValueChangeListeners.add(listener);
			}
		}
		tempGlobalValueChangeListeners.clear();
		if (owner!=null) {
			owner.fireValueChanged(event, false);
		}
	}
}
