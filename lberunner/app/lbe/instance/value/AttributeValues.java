package lbe.instance.value;

import java.util.List;

import lbe.instance.Instance;

public interface AttributeValues<I extends Instance, Item extends Object> 
	extends AttributeValue<I, List<Item>>, ReadOnlyAttributeValues<I, Item> {
	
	public void add(Item item);
}
