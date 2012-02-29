package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.InstanceAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class ReadOnlyAttributeValueImpl<I extends Instance, Value extends Object> implements ReadOnlyAttributeValue<I, Value> {

	public enum ValueDetermination {RELEVANCE, RULE, STORED, DEFAULT, NONE}
	private static class Observer {
		ValueChangeObserver observer;
		boolean permanent;
	}

	
	protected final Attribute<I, Value, ? extends Object> model;
	protected final I forInstance;
	
	transient ArrayList<Observer> tempValueChangeListeners = new ArrayList<Observer>(); 
	transient ArrayList<Observer> valueChangeListeners = new ArrayList<Observer>(); 
	
	private transient ValueAndLevel<Value> cached;
	private transient ObservationsOutdatedObserver basedOn;
	
	private ValueChangeObserver valueChangeListener = new ValueChangeObserver() {

		@Override
		public void valueChanged(ValueChangeEvent event) {
			ValueAndLevel<Value> oldCached = cached;
			ObservationsOutdatedObserver oldBasedOn = basedOn;
			cached = null;
			basedOn = null;
			boolean success = false;
			try {
				fireValueChanged(oldCached, getStoredValue(), getStoredValue(), event.getOperation());
				success = true;
			} finally {
				if (!success) {
					// Rollback everything
					if (basedOn!=null) {
						basedOn.remove();
					}
					basedOn = oldBasedOn;
					cached = oldCached;
				}
			}
		}
	};
	
	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public Attribute<I, Value, ? extends Object> getModel() {
		return model;
	}
	
	/**
	 * For subclasses
	 * @return The value previously cached
	 */
	protected ValueAndLevel<Value> invalidateCachedValue() {
		ValueAndLevel<Value> result = cached;
		if (basedOn!=null) {
			basedOn.remove();
			basedOn = null;
		}
		cached = null;
		return result;
	}
	
	@Deprecated
	public Value get() {
		return getValue();
	}
	
	public Value getValue() {
		return getValueAndLevel().getValue();
	}

	@Override
	public ValueAndLevel<Value> getValueAndLevel() {
		InstanceAdministration registry = forInstance.getInstanceAdministration();
		registry.registerObservation(this);
		ensureCached(registry);
		return cached;
	}
	
	private void ensureCached(InstanceAdministration registry) {
		if (cached==null) {
			registry.startRecordingObservations();
			calculateValue();
			Observations observations = registry.stopRecordingObservations();
			if (observations.size()>0) {
				basedOn = new ObservationsOutdatedObserver(observations, valueChangeListener);
			}
		}
	}
	
	// The logic for determining the value
	private void calculateValue() {
		Attribute<I, Value, ? extends Object> attribute = getModel();
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
		Deduction<Value> ruleDeduction = attribute.getRule();
		if (ruleDeduction!=null) {
			ValueAndLevel<Value> result = ruleDeduction.deduct(context);
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
		Deduction<Value> defaultDeduction = attribute.getDefault();
		if (defaultDeduction!=null) {
			ValueAndLevel<Value> defaultValue = defaultDeduction.deduct(context);
			cached = defaultValue;
			return;
		}
		cached = ValueAndLevel.inconclusive();
	}
	
	protected void fireValueChanged(ValueAndLevel<Value> oldValue, Value oldStoredValue, Value newStoredValue, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, oldValue, oldStoredValue, newStoredValue, operation);
		fireEvent(event);
	}
	
	/**
	 * Takes extra care to undo pending changes when exceptions occur
	 */
	protected void fireEvent(ValueChangeEvent event) {
		ArrayList<Observer> tempListenersBuffer = tempValueChangeListeners;
		tempValueChangeListeners = valueChangeListeners;
		valueChangeListeners = tempListenersBuffer;
		valueChangeListeners.clear();
		int tempIndex = 0;
		boolean success = false;
		try {
			event.getOperation().pauseRecordingUndoEvents();
			for (;tempIndex<tempValueChangeListeners.size();tempIndex++) {
				Observer listener = tempValueChangeListeners.get(tempIndex);
				listener.observer.valueChanged(event);
				if (listener.permanent) {
//					System.out.println("Re-adding listener "+listener);
					valueChangeListeners.add(listener);
				}
			}
			forInstance.fireValueChanged(event, true);
			afterFiringChange(event);
			success = true;
		} finally {
			event.getOperation().resumeRecordingUndoEvents();
			if (success) {
				event.getOperation().addEventToUndo(event);
			} else {
				// The rollback procedure
//				System.out.println("Rolling back "+this);
				ValueChangeEvent undoEvent = event.getUndoEvent();
				cached = (ValueAndLevel<Value>) event.getOldValue();
				if (event.getOldStoredValue()!=null) {
					setStoredValue((Value) event.getOldStoredValue());
				}
				for (int i=valueChangeListeners.size()-1;i>=0;i--) {
					Observer listener = valueChangeListeners.get(i);
					listener.observer.valueChanged(undoEvent);
				}
				for (int i=tempIndex;i<tempValueChangeListeners.size();i++) {
					// Readd the listeners that weren't informed (including the one that threw an exception)
//					System.out.println("Re-adding oblivious listener "+tempValueChangeListeners.get(i));
					valueChangeListeners.add(tempValueChangeListeners.get(i));
				}
			}
			tempValueChangeListeners.clear();
		}
	}

	/**
	 * Can be overridden by subclasses to change reverse relation for example.
	 * Will be called after all changes fire, but before the operation completes
	 * @param event
	 */
	protected void afterFiringChange(ValueChangeEvent event) {
	}

	@Override
	public boolean hasStoredValue() {
		return getStoredValue()!=null;
	}
	
	protected Value getStoredValue() {
		return null;
	}

	protected void setStoredValue(Value newStoredValue) {
		throw new RuntimeException("Only implemented in subclass");
	}
	
	@Override
	public void addValueChangeListener(ValueChangeObserver listener) {
		addValueChangeListener(listener, false);
	}

	@Override
	public void addValueChangeListener(ValueChangeObserver listener, boolean permanent) {
//		System.out.println("Adding listener "+listener);
		// This statement usually does nothing. The value is normally already deduced. Listening to changes in an unknown value is rarely useful.
		ensureCached(forInstance.getInstanceAdministration());
		Observer entry = new Observer();
		entry.observer = listener;
		entry.permanent = permanent;
		valueChangeListeners.add(entry);
	}

	@Override
	public void removeValueChangeListener(ValueChangeObserver listener) {
		Iterator<Observer> iterator = this.valueChangeListeners.iterator();
		while (iterator.hasNext()) {
			Observer entry = iterator.next();
			if (entry.observer==listener) {
				iterator.remove();
				return;
			}
		}
		throw new NoSuchElementException();
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
		ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object> o = 
			(ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object>) other;
		return (o.forInstance==forInstance && o.model==model);
	}

}
