package org.instantlogic.core.value.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.util.ValueChangeEvent;
import org.instantlogic.core.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.core.value.AttributeValues;


public class AttributeValuesImpl<I extends SimpleInstance<I>, Item extends Object> 
	extends AttributeValueImpl<I, List<Item>>
	implements AttributeValues<I, Item>{

	public AttributeValuesImpl(I forInstance, Attribute<I, List<Item>, Item> model) {
		super(forInstance, model);
	}

	@Override
	public void add(Item item) {
		getValue();
		super.getValue().add(item);
		int index = super.getValue().size()-1;
		fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item);
	}
	
	@Override
	public void insert(Item item, int index) {
		getValue();
		super.getValue().add(index, item);
		fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item);
	}

	@Override
	public Item remove(int index) {
		getValue();
		Item item = super.getValue().remove(index);
		fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item);
		return item;
	}
	
	
	
	protected void fireChange(MultiValueUpdateType type, int index, Item item) {
		ValueChangeEvent event = new ValueChangeEvent(this, getValueAndLevel(), type, index, item);
		fireEvent(event);
	}
	
	@Override
	public List<Item> getValue() {
		// Pragmatic approach: Multivalue attributes are never unknown, unless a deduction is given.
		if (!isStored() && getModel().getDefault()==null && getModel().getRule()==null) {
			set(new ArrayList<Item>());
		}
		return Collections.unmodifiableList(super.getValue());
	}
}
