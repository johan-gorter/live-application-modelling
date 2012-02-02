package org.instantlogic.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.util.ValueChangeEvent;
import org.instantlogic.core.util.ValueChangeListener;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.AttributeValues;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.ReadOnlyRelationValues;
import org.instantlogic.core.value.RelationValue;
import org.instantlogic.core.value.RelationValues;
import org.instantlogic.core.value.impl.AttributeValueImpl;
import org.instantlogic.core.value.impl.AttributeValuesImpl;
import org.instantlogic.core.value.impl.ReadOnlyAttributeValueImpl;
import org.instantlogic.core.value.impl.ReadOnlyRelationValueImpl;
import org.instantlogic.core.value.impl.RelationValueImpl;
import org.instantlogic.core.value.impl.RelationValuesImpl;
import org.instantlogic.core.value.impl.ReverseRelationValueImpl;
import org.instantlogic.core.value.impl.ReverseRelationValuesImpl;

@SuppressWarnings("unchecked")
public abstract class SimpleInstance<I extends SimpleInstance<I>> implements Instance<I> {

	private static class GlobalValueChangeListener {
		ValueChangeListener listener;
		boolean alsoForOwnedInstances;
	}
	
	private List<GlobalValueChangeListener> tempGlobalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	private List<GlobalValueChangeListener> globalValueChangeListeners = new ArrayList<GlobalValueChangeListener>();
	
	private SimpleInstance<?> owner = null;
	
	private final CaseInstance<?> caseInstance;
	
	private final long id;
	
	public SimpleInstance(CaseInstance<?> caseInstance, long id) {
		this.caseInstance = caseInstance;
		if (caseInstance!=null) {
			this.id = caseInstance.getRegistry().registerInstance(this, id);
		} else {
			this.id = 0; // This means we are the caseInstance
		}
	}

	public CaseInstance<?> getCase() {
		return caseInstance;
	}
	
	public long getInstanceId() {
		return id;
	}
	
	public void registerOwner(SimpleInstance<?> owner) {
		if (this.owner!=null && owner!=null) {
			throw new RuntimeException("This instance is already owned by "+this.owner);
		}
		this.owner = owner;
	}

	protected<Value extends Object> ReadOnlyAttributeValueImpl<I, Value> createReadOnlyAttributeValue(Attribute<I, Value, Value> attribute) {
		return new ReadOnlyAttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	protected<Value extends Object> AttributeValue<I, Value> createAttributeValue(Attribute<I, Value, Value> attribute) {
		return new AttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	protected<Value extends Object> AttributeValues<I, Value> createAttributeValues(Attribute<I, List<Value>, Value> attribute) {
		return new AttributeValuesImpl<I, Value>((I)this, attribute);
	}

	protected<To extends Instance<To>> ReadOnlyRelationValue<I, To> createReadOnlyRelationValue(Relation<I, To, To> relation) {
		return new ReadOnlyRelationValueImpl<I, To>((I)this, relation);
	}
	
	protected<To extends Instance<To>> RelationValue<I, To> createRelationValue(Relation<I, To, To> relation) {
		return new RelationValueImpl<I, To>((I)this, relation);
	}
	
	protected<To extends Instance<To>> RelationValues<I, To> createRelationValues(Relation<I, List<To>, To> relation) {
		return new RelationValuesImpl<I, To>((I)this, relation);
	}

	protected<To extends Instance<To>> ReadOnlyRelationValue<I, To> createReverseRelationValue(Relation<I, To, To> relation) {
		return new ReverseRelationValueImpl<I, To>((I)this, relation);
	}
	
	protected<To extends Instance<To>> ReadOnlyRelationValues<I, To> createReverseRelationValues(Relation<I, List<To>, To> relation) {
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
		return getModel().toString()+"#"+getInstanceId()+name;
	}
	
	@Override
	public void addGlobalValueChangeListener(ValueChangeListener listener, boolean alsoForOwnedInstances) {
		GlobalValueChangeListener gvcl = new GlobalValueChangeListener();
		gvcl.listener = listener;
		gvcl.alsoForOwnedInstances = alsoForOwnedInstances;
		globalValueChangeListeners.add(gvcl);
	}
	
	@Override
	public void removeGlobalValueChangeListener(ValueChangeListener listener) {
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
				reAdd = listener.listener.valueChanged(event);
			}
			if (reAdd) {
				globalValueChangeListeners.add(listener);
			}
		}
		tempGlobalValueChangeListeners.clear();
		if (owner!=null) {
			((SimpleInstance)owner).fireValueChanged(event, false);
		}
	}
}
