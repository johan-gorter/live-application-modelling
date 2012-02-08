package org.instantlogic.fabric.value;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeListener;


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
