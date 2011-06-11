package lbe.instance.value.impl;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.ReadOnlyRelationValues;
import lbe.model.Attribute;
import lbe.model.Relation;

public class ReverseRelationValuesImpl<I extends Instance, From extends Instance>
	extends ReadOnlyAttributeValueImpl<I, List<From>>
	implements ReadOnlyRelationValues<I, From>{

	private List<From> reverseValue = new ArrayList<From>();
	
	public ReverseRelationValuesImpl(I forInstance, Relation<I, List<From>, From> model) {
		super(forInstance, (Attribute)model);
	}
	
	@Override
	public List<From> get() {
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
