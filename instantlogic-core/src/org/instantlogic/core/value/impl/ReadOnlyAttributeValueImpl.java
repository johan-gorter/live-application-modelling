package org.instantlogic.core.value.impl;

import java.util.ArrayList;

import org.instantlogic.core.Instance;
import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.util.Observations;
import org.instantlogic.core.util.SingleInstanceDeductionContext;
import org.instantlogic.core.util.ValueAndLevel;
import org.instantlogic.core.util.ValueChangeEvent;
import org.instantlogic.core.util.ValueChangeListener;
import org.instantlogic.core.value.ReadOnlyAttributeValue;

public class ReadOnlyAttributeValueImpl<I extends SimpleInstance<I>, V extends Object> implements ReadOnlyAttributeValue<I, V> {

	public enum ValueDetermination {RELEVANCE, RULE, STORED, DEFAULT, NONE}
	
	protected final Attribute<I, V, ? extends Object> model;
	protected final I forInstance;
	
	private transient ArrayList<ValueChangeListener> oneTimeListeners = new ArrayList<ValueChangeListener>(); 
	
	private transient ValueAndLevel<V> cached;
	private transient Observations basedOn;
	
	private ValueChangeListener valueChangeListener = new ValueChangeListener() {

		@Override
		public boolean valueChanged(ValueChangeEvent event) {
			ValueAndLevel<V> oldValue = cached;
			basedOn = null;
			cached = null;
			fireValueChanged(oldValue, getStoredValue(), getStoredValue());
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
	
	@Override
	public ValueAndLevel<V> getValueAndLevel() {
		forInstance.getCase().getRegistry().registerObservation(this);
		if (cached==null) {
			forInstance.getCase().getRegistry().startRecordingObservations();
			calculateValue();
			Observations observations = forInstance.getCase().getRegistry().stopRecordingObservations();
			if (observations.size()>0) {
				basedOn = observations;
				observations.setOneTimeOutdatedListener(valueChangeListener);
			}
		}
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
	
	protected void fireValueChanged(ValueAndLevel<V> oldValue, V oldStoredValue, V newStoredValue) {
		ValueChangeEvent event = new ValueChangeEvent(this, cached, oldStoredValue, getStoredValue());
		fireEvent(event);
	}
	
	protected void fireEvent(ValueChangeEvent event) {
		ArrayList<ValueChangeListener> listeners = oneTimeListeners;
		oneTimeListeners = new ArrayList<ValueChangeListener>();
		for (ValueChangeListener listener: listeners) {
			listener.valueChanged(event);
		}
		forInstance.fireValueChanged(event, true);
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
		oneTimeListeners.add(listener);
	}

	@Override
	public void removeValueChangeListener(ValueChangeListener listener) {
		oneTimeListeners.remove(listener);
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
		return new Long(forInstance.getInstanceId()).hashCode()+model.getName().hashCode();
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
