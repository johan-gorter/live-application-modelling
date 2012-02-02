package org.instantlogic.core.value.impl;

import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.value.ReadOnlyRelationValue;


public class ReadOnlyRelationValueImpl<I extends SimpleInstance<I>, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value>
	implements ReadOnlyRelationValue<I, Value>{

	public ReadOnlyRelationValueImpl(I forInstance,
			Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}
	
	@Override
	public Relation<I, Value, ? extends Object> getModel() {
		return (Relation<I, Value, ? extends Object>) super.getModel();
	}
	
}
