package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeListener;
import org.instantlogic.fabric.value.AttributeValue;


public class AttributeValueImpl<I extends Instance<I>, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value> 
	implements AttributeValue<I, Value>{
	
	private Value storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

	public Value getValue() {
		if (storedValue!=null) {
			forInstance.getInstanceAdministration().registerObservation(this);
			return storedValue;
		}
		return super.getValue();
	}

	public void set(Value value) {
		Operation operation = forInstance.getInstanceAdministration().startOperation();
		try {
			Value oldStoredValue = storedValue;
			ValueAndLevel<Value> oldValue = invalidateCachedValue();
			storedValue = value;
			fireValueChanged(oldValue, oldStoredValue, value, operation);
			operation.complete();
		} finally {
			operation.clearUndoEvents(); // Events triggered by valuechanges should undo their changes when receiving undo events.
			if (!operation.completed()) {
				
			}
			operation.close();
		}
	}
	
	/**
	 * Takes extra care to undo pending changes when exceptions occur
	 */
	protected void fireEvent(ValueChangeEvent event) {
		if (event.getOldStoredValue()==event.getNewStoredValue()) {
			super.fireEvent(event); // No need for extra care
			return;
		}
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
					valueChangeListeners.add(listener);
				}
			}
			forInstance.fireValueChanged(event, true);
			success = true;
		} finally {
			if (success) {
				event.getOperation().addUndoEvent(event);
			} else {
				// The rollback procedure
				ValueAndLevel<Value> failedNewValue = invalidateCachedValue();
				storedValue = (Value) event.getOldStoredValue();
				ValueChangeEvent undoEvent = new ValueChangeEvent(event, failedNewValue);
				for (int i=valueChangeListeners.size()-1;i>=0;i--) {
					ValueChangeListener listener = valueChangeListeners.get(i);
					if (!listener.valueChanged(undoEvent)) {
						valueChangeListeners.remove(i);
					}
				}
				for (int i=tempIndex;i<tempValueChangeListeners.size();i++) {
					// Readd the listeners that weren't informed (including the one that threw an exception) 
					valueChangeListeners.add(tempValueChangeListeners.get(i));
				}
			}
			tempValueChangeListeners.clear();
		}
	}
	
	

	@Override
	protected Value getStoredValue() {
		return storedValue;
	}
	

	public boolean isStored() {
		return storedValue!=null;
	}
}
