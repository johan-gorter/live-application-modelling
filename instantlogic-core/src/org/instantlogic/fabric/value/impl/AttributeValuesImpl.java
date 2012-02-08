package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValues;


public class AttributeValuesImpl<I extends Instance<I>, Item extends Object> 
	extends AttributeValueImpl<I, List<Item>>
	implements AttributeValues<I, Item>{

	public AttributeValuesImpl(I forInstance, Attribute<I, List<Item>, Item> model) {
		super(forInstance, model);
	}

	@Override
	public void add(Item item) {
		Operation operation = forInstance.getInstanceAdministration().startOperation();
		try {
			getValue();
			super.getValue().add(item);
			int index = super.getValue().size()-1;
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	@Override
	public void insert(Item item, int index) {
		Operation operation = forInstance.getInstanceAdministration().startOperation();
		try {
			getValue();
			super.getValue().add(index, item);
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
		} finally {
			operation.close();
		}
	}

	@Override
	public Item remove(int index) {
		Operation operation = forInstance.getInstanceAdministration().startOperation();
		try {
			getValue();
			Item item = super.getValue().remove(index);
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
			return item;
		} finally {
			operation.close();
		}
	}
	
	protected void fireChange(MultiValueUpdateType type, int index, Item item, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, getValueAndLevel(), type, index, item, operation);
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
