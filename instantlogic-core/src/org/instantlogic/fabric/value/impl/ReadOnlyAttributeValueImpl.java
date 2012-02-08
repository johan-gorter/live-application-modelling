package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.InstanceAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeListener;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class ReadOnlyAttributeValueImpl<I extends Instance<I>, V extends Object> implements ReadOnlyAttributeValue<I, V> {

	public enum ValueDetermination {RELEVANCE, RULE, STORED, DEFAULT, NONE}
	
	protected final Attribute<I, V, ? extends Object> model;
	protected final I forInstance;
	
	transient ArrayList<ValueChangeListener> tempValueChangeListeners = new ArrayList<ValueChangeListener>(); 
	transient ArrayList<ValueChangeListener> valueChangeListeners = new ArrayList<ValueChangeListener>(); 
	
	private transient ValueAndLevel<V> cached;
	private transient Observations basedOn;
	
	private ValueChangeListener valueChangeListener = new ValueChangeListener() {

		@Override
		public boolean valueChanged(ValueChangeEvent event) {
			ValueAndLevel<V> oldValue = cached;
			basedOn = null;
			cached = null;
			fireValueChanged(oldValue, getStoredValue(), getStoredValue(), event.getOperation());
			return false;
		}
	};
	
	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, V, ? extends Object> model) {
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public Attribute<I, V, ? extends Object> getModel() {
		return model;
	}
	
	/**
	 * For subclasses
	 * @return The value previously cached
	 */
	protected ValueAndLevel<V> invalidateCachedValue() {
		ValueAndLevel<V> result = cached;
		if (basedOn!=null) {
			basedOn.removeOneTimeOutdatedListener();
			basedOn = null;
		}
		cached = null;
		return result;
	}
	
	private void ensureCached(InstanceAdministration registry) {
		if (cached==null) {
			registry.startRecordingObservations();
			calculateValue();
			Observations observations = registry.stopRecordingObservations();
			if (observations.size()>0) {
				basedOn = observations;
				observations.setOneTimeOutdatedListener(valueChangeListener);
			}
		}
	}
	
	@Override
	public ValueAndLevel<V> getValueAndLevel() {
		InstanceAdministration registry = forInstance.getInstanceAdministration();
		registry.registerObservation(this);
		ensureCached(registry);
		return cached;
	}
	
	@Deprecated
	public V get() {
		return getValue();
	}
	
	
	public V getValue() {
		return getValueAndLevel().getValue();
	}

	// The logic for determining the value
	private void calculateValue() {
		Attribute<I, V, ? extends Object> attribute = getModel();
		SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(forInstance);
		//Relevance
		Deduction<Boolean> relevance = attribute.getRelevance();
		if (relevance!=null) {
			ValueAndLevel<Boolean> relevanceValue = relevance.deduct(context);
			if (relevanceValue.getValue()!=Boolean.TRUE) {
				cached = ValueAndLevel.irrelevant();
				return;
			}
		}
		//Rule
		Deduction<V> ruleDeduction = attribute.getRule();
		if (ruleDeduction!=null) {
			ValueAndLevel<V> result = ruleDeduction.deduct(context);
			if (result.isConclusive()) {
				cached = result;
				return;
			}
		}
		//Stored value
		if (getStoredValue()!=null) {
			cached = ValueAndLevel.stored(getStoredValue());
			return;
		}
		//Default
		Deduction<V> defaultDeduction = attribute.getDefault();
		if (defaultDeduction!=null) {
			ValueAndLevel<V> defaultValue = defaultDeduction.deduct(context);
			cached = defaultValue;
			return;
		}
		cached = ValueAndLevel.inconclusive();
	}
	
	protected void fireValueChanged(ValueAndLevel<V> oldValue, V oldStoredValue, V newStoredValue, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, oldValue, oldStoredValue, getStoredValue(), operation);
		fireEvent(event);
	}
	
	protected void fireEvent(ValueChangeEvent event) {
		ArrayList<ValueChangeListener> tempListenersBuffer = tempValueChangeListeners;
		tempValueChangeListeners = valueChangeListeners;
		valueChangeListeners = tempListenersBuffer;
		valueChangeListeners.clear();
		int tempIndex = 0;
		boolean success = false;
		try {
			for (;tempIndex<tempValueChangeListeners.size();tempIndex++) {
				ValueChangeListener listener = tempValueChangeListeners.get(tempIndex);
				boolean readd = listener.valueChanged(event);
				if (readd) {
					ensureCached(forInstance.getInstanceAdministration());
					valueChangeListeners.add(listener);
				}
			}
			forInstance.fireValueChanged(event, true);
			success = true;
		} finally {
			if (!success) {
				for (int i=tempIndex;i<tempValueChangeListeners.size();i++) {
					// Readd the listeners that weren't informed (including the one that threw an exception) 
					valueChangeListeners.add(tempValueChangeListeners.get(i));
				}
			}
			tempValueChangeListeners.clear();
		}
	}
	
	@Override
	public boolean hasStoredValue() {
		return getStoredValue()!=null;
	}
	
	protected V getStoredValue() {
		return null;
	}

	@Override
	public void addValueChangeListener(ValueChangeListener listener) {
		// This statement usually does nothing. The value is normally already deduced. Listening to changes in an unknown value is rarely useful.
		ensureCached(forInstance.getInstanceAdministration()); 
		valueChangeListeners.add(listener);
	}

	@Override
	public void removeValueChangeListener(ValueChangeListener listener) {
		valueChangeListeners.remove(listener);
	}
	
	@Override
	public I getInstance() {
		return forInstance;
	}
	
	
	
	@Override
	public String toString() {
		return this.forInstance.toString()+"."+this.model.toString();
	}
	
	@Override
	public int hashCode() {
		return forInstance.getInstanceLocalId().hashCode()+model.getName().hashCode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (other==null || other.getClass()!=getClass()) return false;
		ReadOnlyAttributeValueImpl<? extends Instance<?>, ? extends Object> o = 
			(ReadOnlyAttributeValueImpl<? extends Instance<?>, ? extends Object>) other;
		return (o.forInstance==forInstance && o.model==model);
	}

}
