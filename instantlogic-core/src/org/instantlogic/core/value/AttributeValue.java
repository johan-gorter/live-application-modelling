package org.instantlogic.core.value;

import org.instantlogic.core.Instance;

public interface AttributeValue<I extends Instance<I>, V extends Object> extends ReadOnlyAttributeValue<I, V> {
	
	public void set(V value);
	
	boolean isStored();
	
}
