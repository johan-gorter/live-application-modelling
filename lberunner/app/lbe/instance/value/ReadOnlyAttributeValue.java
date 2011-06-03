package lbe.instance.value;

import lbe.instance.Instance;
import lbe.model.Attribute;

public interface ReadOnlyAttributeValue<I extends Instance, Value extends Object> {

	Attribute<I, Value, ? extends Object> getModel();
	
	Value get();
	
}
