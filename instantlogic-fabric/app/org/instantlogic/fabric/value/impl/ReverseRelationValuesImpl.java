package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;


public class ReverseRelationValuesImpl<I extends Instance, From extends Instance>
	extends ReadOnlyAttributeValueImpl<I, Multi<From>>
	implements ReadOnlyRelationValues<I, From>{

	private List<From> values = new ArrayList<From>();
	private Multi<From> reverseValue = new Multi<From>(values);
	
	public ReverseRelationValuesImpl(I forInstance, Relation<I, Multi<From>, From> relation) {
		super(forInstance, (Attribute<I, Multi<From>, ? extends Object>)relation);
	}
	
	@Override
	public Multi<From> getValue() {
		return reverseValue;
	}

	public void addReverse(From reverseValue, Operation operation) {
		this.values.add(reverseValue);
		fireEvent(new ValueChangeEvent(this, ValueAndLevel.deduced(this.reverseValue), MultiValueUpdateType.INSERT, this.values.size()-1, reverseValue, operation));
	}

	public void removeReverse(From reverseValue, Operation operation) {
		int index = this.values.indexOf(reverseValue);
		if (index<0) {
			throw new RuntimeException("Reverse value not found: "+reverseValue);
		}
		this.values.remove(index);
		fireEvent(new ValueChangeEvent(this, ValueAndLevel.deduced(this.reverseValue), index, reverseValue, operation));
	}
	
	@Override
	public Relation<I, Multi<From>, ? extends Object> getModel() {
		return getModel();
	}
}
