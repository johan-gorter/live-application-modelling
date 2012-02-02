package org.instantlogic.core.value;

import java.util.List;

import org.instantlogic.core.Instance;


// Value: List<Instance> or Instance
public interface ReadOnlyRelationValues<I extends Instance<I>, To extends Instance<To>> 
	extends ReadOnlyAttributeValues<I, To>,  ReadOnlyRelationValue<I, List<To>>{
	
}
