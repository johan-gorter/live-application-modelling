package org.instantlogic.core.value;

import org.instantlogic.core.Instance;


public interface RelationValue<I extends Instance<I>, Value extends Object> 
	extends ReadOnlyRelationValue<I, Value>, AttributeValue<I, Value> {

}
