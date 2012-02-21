package org.instantlogic.fabric.value;

import java.util.List;

import org.instantlogic.fabric.Instance;


public interface RelationValues<I extends Instance, Item extends Instance> 
	extends AttributeValues<I, Item>, RelationValue<I, List<Item>>, ReadOnlyRelationValues<I, Item>
{

}
