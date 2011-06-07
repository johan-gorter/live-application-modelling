package lbe.instance.value.impl;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.AttributeValues;
import lbe.model.Attribute;

public class AttributeValuesImpl<I extends Instance, Item extends Object> 
	extends AttributeValueImpl<I, List<Item>>
	implements AttributeValues<I, Item>{

	public AttributeValuesImpl(I forInstance, Attribute<I, List<Item>, Item> model) {
		super(forInstance, model);
	}

	@Override
	public void add(Item item) {
		if (!isStored()) {
			set(new ArrayList<Item>());
		}
		this.get().add(item);
	}
	
}
