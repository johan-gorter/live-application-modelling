package org.instantlogic.fabric.value;

import java.util.List;

import org.instantlogic.fabric.Instance;


public interface AttributeValues<I extends Instance<I>, Item extends Object> 
	extends AttributeValue<I, List<Item>>, ReadOnlyAttributeValues<I, Item> {
	
	public void add(Item item);

	public void insert(Item item, int index);

	public Item remove(int index);
}
