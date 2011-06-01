package lbe.instance;

import lbe.model.Attribute;

public class AttributeValue<I extends Instance, V extends Object> extends ReadonlyAttributeValue<I, V> {
	
	private V storedValue;
	
	public AttributeValue(I forInstance, Attribute<I, V> model) {
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
