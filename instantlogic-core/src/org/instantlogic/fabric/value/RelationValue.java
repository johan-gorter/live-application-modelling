package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;


public interface RelationValue<I extends Instance<I>, Value extends Object> 
	extends ReadOnlyRelationValue<I, Value>, AttributeValue<I, Value> {

}
