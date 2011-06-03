package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.model.Attribute;

public class AttributeValueImpl<I extends Instance, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value> 
	implements AttributeValue<I, Value>{
	
	private Value storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

	public Value get() {
		if (storedValue!=null) {
			return storedValue;
		}
		return super.get();
	}

	public void set(Value value) {
		storedValue = value;
	}

	public boolean isStored() {
		return storedValue!=null;
	}
}
