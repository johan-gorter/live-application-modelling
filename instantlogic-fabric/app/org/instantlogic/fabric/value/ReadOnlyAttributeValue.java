package org.instantlogic.fabric.value;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeObserver;


public interface ReadOnlyAttributeValue<I extends Instance, Value extends Object> {

	Attribute<I, Value, ? extends Object> getModel();
	
	I getInstance();
	
	Value getValue();
	
	@Deprecated
	Value get();
	
	ValueAndLevel<Value> getValueAndLevel();
	
	boolean hasStoredValue();
	
	public void addValueChangeListener(ValueChangeObserver listener);

	public void addValueChangeListener(ValueChangeObserver listener, boolean permanent);

	public void removeValueChangeListener(ValueChangeObserver listener);
}