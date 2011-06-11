package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.model.Attribute;
import lbe.model.Relation;

public class ReadOnlyRelationValueImpl<I extends Instance, Value extends Object> 
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
