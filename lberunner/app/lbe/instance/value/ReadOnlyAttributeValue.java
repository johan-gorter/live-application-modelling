package lbe.instance.value;

import lbe.instance.Instance;
import lbe.model.Attribute;

public interface ReadOnlyAttributeValue<I extends Instance, V extends Object> {

	Attribute<I, V> getModel();
	
	V get();

}
