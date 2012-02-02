package org.instantlogic.core.value;


import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.util.ValueAndLevel;
import org.instantlogic.core.util.ValueChangeListener;


public interface ReadOnlyAttributeValue<I extends Instance<I>, Value extends Object> {

	Attribute<I, Value, ? extends Object> getModel();
	
	I getInstance();
	
	Value getValue();
	
	@Deprecated
	Value get();
	
	ValueAndLevel<Value> getValueAndLevel();
	
	boolean hasStoredValue();
	
	public void addValueChangeListener(ValueChangeListener listener);

	public void removeValueChangeListener(ValueChangeListener listener);
}
