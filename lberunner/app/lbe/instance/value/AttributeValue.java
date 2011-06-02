package lbe.instance.value;

import lbe.instance.Instance;

public interface AttributeValue<I extends Instance, V extends Object> extends ReadOnlyAttributeValue<I, V> {
	
	public void set(V value);
	
}
