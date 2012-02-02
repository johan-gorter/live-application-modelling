package org.instantlogic.core.value.impl;

import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.util.ValueAndLevel;
import org.instantlogic.core.value.AttributeValue;


public class AttributeValueImpl<I extends SimpleInstance<I>, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value> 
	implements AttributeValue<I, Value>{
	
	private Value storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

	public Value getValue() {
		if (storedValue!=null) {
			forInstance.getCase().getRegistry().registerObservation(this);
			return storedValue;
		}
		return super.getValue();
	}

	public void set(Value value) {
		Value oldStoredValue = storedValue;
		storedValue = value;
		ValueAndLevel<Value> oldValue = invalidateCachedValue();
		fireValueChanged(oldValue, oldStoredValue, value);
	}

	@Override
	protected Value getStoredValue() {
		return storedValue;
	}
	

	public boolean isStored() {
		return storedValue!=null;
	}
}
