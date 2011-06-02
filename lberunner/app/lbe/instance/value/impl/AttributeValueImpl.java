package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.model.Attribute;

public class AttributeValueImpl<I extends Instance, V extends Object> extends ReadOnlyAttributeValueImpl<I, V> {
	
	private V storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, V> model) {
		super(forInstance, model);
	}

	public V get() {
		if (storedValue!=null) {
			return storedValue;
		}
		return super.get();
	}

	public void set(V value) {
		storedValue = value;
	}

	public boolean isStored() {
		return storedValue!=null;
	}
}
