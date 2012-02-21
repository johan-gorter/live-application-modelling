package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;


public class ReverseRelationValuesImpl<I extends Instance, From extends Instance>
	extends ReadOnlyAttributeValueImpl<I, List<From>>
	implements ReadOnlyRelationValues<I, From>{

	private List<From> reverseValue = new ArrayList<From>();
	
	public ReverseRelationValuesImpl(I forInstance, Relation<I, List<From>, From> relation) {
		super(forInstance, (Attribute<I, List<From>, ? extends Object>)relation);
	}
	
	@Override
	public List<From> getValue() {
		return reverseValue;
	}

	public void addReverse(From reverseValue) {
		this.reverseValue.add(reverseValue);
	}

	@Override
	public Relation<I, List<From>, ? extends Object> getModel() {
		return getModel();
	}
}
