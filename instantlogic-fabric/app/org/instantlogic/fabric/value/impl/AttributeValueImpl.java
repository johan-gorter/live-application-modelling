package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.AttributeValue;


public class AttributeValueImpl<I extends Instance, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value> 
	implements AttributeValue<I, Value>{
	
	private Value storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

	@Override
	public void setValue(Value value) {
		Operation operation = forInstance.getInstanceAdministration().startOperation();
		try {
			Value oldStoredValue = storedValue;
			ValueAndLevel<Value> oldValue = invalidateCachedValue();
			storedValue = value;
			fireValueChanged(oldValue, oldStoredValue, value, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	@Override
	protected Value getStoredValue() {
		return storedValue;
	}
	
	/**
	 * For internal use only.
	 */
	@Override
	protected void setStoredValue(Value newStoredValue) {
		storedValue = newStoredValue;
	}
	

	public boolean isStored() {
		return storedValue!=null;
	}
}
