package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Multi;


public class AttributeValuesImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValuesImpl<I, Item>
	implements AttributeValues<I, Item>{

	private List<Item> storedValues;
	private Multi<Item> storedValue;
	
	public AttributeValuesImpl(I forInstance, Attribute<I, Multi<Item>, Item> model) {
		super(forInstance, model);
	}
	
	private Operation startOperation() {
		ensureStored();
		return forInstance.getInstanceAdministration().startOperation();
	}

	private void ensureStored() {
		if (storedValues==null) {
			storedValues = new ArrayList<Item>();
			storedValue = new Multi<Item>(storedValues);
		}
	}

	@Override
	public void addValue(Item item) {
		Operation operation = startOperation();
		try {
			storedValues.add(item);
			int index = super.getValue().size()-1;
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	@Override
	public void insertValue(Item item, int index) {
		Operation operation = startOperation();
		try {
			storedValues.add(index, item);
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
		} finally {
			operation.close();
		}
	}

	@Override
	public Item removeValue(int index) {
		Operation operation = startOperation();
		try {
			Item item = storedValues.remove(index);
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
	protected Multi<Item> getStoredValue() {
		ensureStored();
		return storedValue;
	}
}
