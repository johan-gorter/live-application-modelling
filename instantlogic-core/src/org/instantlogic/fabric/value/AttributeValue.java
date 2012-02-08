package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface AttributeValue<I extends Instance<I>, V extends Object> extends ReadOnlyAttributeValue<I, V> {
	
	public void set(V value);
	
	boolean isStored();
	
}
