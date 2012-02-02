package org.instantlogic.core.value;

import java.util.List;

import org.instantlogic.core.Instance;


public interface RelationValues<I extends Instance<I>, Item extends Instance<Item>> 
	extends AttributeValues<I, Item>, RelationValue<I, List<Item>>, ReadOnlyRelationValues<I, Item>
{

}
