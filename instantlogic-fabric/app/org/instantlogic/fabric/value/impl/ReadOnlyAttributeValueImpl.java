package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.CaseAdministration;
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
	
	protected final Attribute<I, Value, ? extends Object> model;
	protected final I forInstance;
	
	transient ArrayList<ValueChangeObserver> valueChangeObservers = new ArrayList<ValueChangeObserver>(); 
	// When this value is the same as globalValueChangeListeners, copy globalValueChangeListeners on write and clear this field.
	transient ArrayList<ValueChangeObserver> iteratingValueChangeObservers = null; 
	transient ArrayList<ValueChangeObserver> nextValueChangeObservers = new ArrayList<ValueChangeObserver>(); 
	transient boolean iteratingNextValueChangeObservers = false;
	
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
	
	public final Value getValue() {
		return getValueAndLevel().getValue();
	}

	@Override
	public ValueAndLevel<Value> getValueAndLevel() {
		CaseAdministration registry = forInstance.getMetadata().getCaseAdministration();
		registry.registerObservation(this);
		ensureCached(registry);
		return cached;
	}
	
	private void ensureCached(CaseAdministration registry) {
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
	@SuppressWarnings("unchecked")
	protected void fireEvent(ValueChangeEvent event) {
		boolean clearIteratingOnExit = false;
		int lastInformedNextIndex = nextValueChangeObservers.size();
		boolean success = false;
		boolean instanceInformed = false;
		List<ValueChangeObserver> iterating = null;
		ListIterator<ValueChangeObserver> iterator = null;
		try {
			// Listeners must undo their actions when they receive the undo event
			event.getOperation().pauseRecordingUndoEvents(); 
			// Reverse relations and such
			beforeFiringChange(event);
			// NextValueChangeObservers
			iteratingNextValueChangeObservers = true;
			while (lastInformedNextIndex>0) {
				ValueChangeObserver observer = nextValueChangeObservers.get(lastInformedNextIndex-1);
				if (observer!=null) {
					observer.valueChanged(event);
				}
				lastInformedNextIndex--;
				nextValueChangeObservers.remove(lastInformedNextIndex);
			}
			// ValueChangeObservers
			if (iteratingValueChangeObservers != valueChangeObservers) {
				iteratingValueChangeObservers = valueChangeObservers;
				clearIteratingOnExit = true;
			}
			iterating = iteratingValueChangeObservers;
			iterator = iterating.listIterator(iterating.size());
			while (iterator.hasPrevious()) {
				ValueChangeObserver listener = iterator.previous();
				listener.valueChanged(event);
			}
			// Observers on the Instance and Instances above
			instanceInformed = true;
			forInstance.getMetadata().fireValueChanged(event, true);
			success = true;
		} finally {
			if (success) {
				event.getOperation().resumeRecordingUndoEvents();
				if (clearIteratingOnExit && iteratingValueChangeObservers == iterating) {
					iteratingValueChangeObservers = null;
				}
				iteratingNextValueChangeObservers = false;
				if (event.storedValueChanged()) {
					event.getOperation().addEventToUndo(event);
				}
			} else {
				// The rollback procedure
				try {
					ValueChangeEvent undoEvent = event.getUndoEvent();
					cached = (ValueAndLevel<Value>) event.getOldValue();
					if (event.getOldStoredValue()!=null) {
						setStoredValue((Value) event.getOldStoredValue());
					}
					
					// Observers on the Instance
					if (instanceInformed) {
						forInstance.getMetadata().fireValueChanged(undoEvent, true);
					}
					// ValueChangeObservers
					if (iterator!=null) {
						if (iterator.hasNext()) {
							if (!instanceInformed) {
								iterator.next(); // Do not reinform the observer that crashed
							}
							while (iterator.hasNext()) {
								iterator.next().valueChanged(undoEvent);
							}
						}
					}
					// Newly added nextValueChangeObservers
					int lastMisinfomedIndex = nextValueChangeObservers.size()-1;
					while (lastInformedNextIndex <= lastMisinfomedIndex) {
						ValueChangeObserver observer = nextValueChangeObservers.get(lastInformedNextIndex);
						if (observer!=null) {
							observer.valueChanged(undoEvent);
						}
						nextValueChangeObservers.remove(lastInformedNextIndex);
						lastMisinfomedIndex--;
					}
				} finally {
					event.getOperation().resumeRecordingUndoEvents();
					if (clearIteratingOnExit && iteratingValueChangeObservers == iterating) {
						iteratingValueChangeObservers = null;
					}
					iteratingNextValueChangeObservers = false;
				}
			}
		}
	}

	/**
	 * Can be overridden by subclasses to change reverse relation for example.
	 * Will be called before all changes fire, but after the value has been set
	 * @param event
	 */
	protected void beforeFiringChange(ValueChangeEvent event) {
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
	
	private void copyGlobalValueChangeListenersIfNeeded() {
		if (iteratingValueChangeObservers==valueChangeObservers) {
			valueChangeObservers = new ArrayList<ValueChangeObserver>(valueChangeObservers);
		}
	}
	
	
	@Override
	public void addValueChangeObserver(ValueChangeObserver observer) {
		// This statement usually does nothing. The value is normally already deduced. Listening to changes on an unknown value is rarely useful.
		ensureCached(forInstance.getMetadata().getCaseAdministration());
		copyGlobalValueChangeListenersIfNeeded();
		valueChangeObservers.add(observer);
	}

	@Override
	public void removeValueChangeObserver(ValueChangeObserver observer) {
		copyGlobalValueChangeListenersIfNeeded();
		Iterator<ValueChangeObserver> iterator = this.valueChangeObservers.iterator();
		while (iterator.hasNext()) {
			ValueChangeObserver entry = iterator.next();
			if (entry==observer) {
				iterator.remove();
				return;
			}
		}
		throw new NoSuchElementException();
	}
	
	@Override
	public void addNextValueChangeObserver(ValueChangeObserver observer) {
		nextValueChangeObservers.add(observer);
	}

	@Override
	public void removeNextValueChangeObserver(ValueChangeObserver observer) {
		if (iteratingNextValueChangeObservers) {
			// We need to be careful
			int index = nextValueChangeObservers.indexOf(observer);
			if (index<0) throw new NoSuchElementException();
			nextValueChangeObservers.set(index, null);
		} else {
			if (!nextValueChangeObservers.remove(observer)) throw new NoSuchElementException();
		}
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
		return forInstance.getMetadata().getInstanceLocalId().hashCode()+model.getName().hashCode();
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
