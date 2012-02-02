package org.instantlogic.core.value.impl;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.value.ReadOnlyRelationValues;


public class ReverseRelationValuesImpl<I extends SimpleInstance<I>, From extends Instance<From>>
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
