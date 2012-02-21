package org.instantlogic.fabric.value;

import java.util.List;

import org.instantlogic.fabric.Instance;


// Value: List<Instance> or Instance
public interface ReadOnlyRelationValues<I extends Instance, To extends Instance> 
	extends ReadOnlyAttributeValues<I, To>,  ReadOnlyRelationValue<I, List<To>>{
	
}
