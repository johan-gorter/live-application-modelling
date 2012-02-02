package org.instantlogic.core.value;

import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Relation;


// Value: List<Instance> or Instance
public interface ReadOnlyRelationValue<I extends Instance<I>, Value extends Object> 
	extends ReadOnlyAttributeValue<I, Value> {

	Relation<I, Value, ? extends Object> getModel();
	
}
