package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.model.Attribute;

public class ReadOnlyRelationValueImpl<I extends Instance, Value extends Object> extends ReadOnlyAttributeValueImpl<I, Value>{

	public ReadOnlyRelationValueImpl(I forInstance,
			Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

}
