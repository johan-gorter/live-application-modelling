package lbe.instance.value.impl;

import java.util.ArrayList;
import java.util.Collections;
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
		get();
		super.get().add(item);
		fireValueChanged();
	}
	
	@Override
	public List<Item> get() {
		// Pragmatic approach: Multivalue attributes are never unknown, unless a deduction is given.
		if (!isStored() && getModel().getDefault()==null) {
			set(new ArrayList<Item>());
		}
		return Collections.unmodifiableList(super.get());
	}
	
	@Override
	public void set(List<Item> value) {
		// TODO Auto-generated method stub
		super.set(value);
	}
	
}
