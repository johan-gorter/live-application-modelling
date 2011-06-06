package lbe.instance.value.impl;

import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.RelationValues;
import lbe.model.Relation;

public class RelationValuesImpl<I extends Instance, To extends Instance>
	extends AttributeValuesImpl<I, To>
	implements RelationValues<I, To> {

	public RelationValuesImpl(I forInstance, Relation<I, List<To>, To> model) {
		super(forInstance, model);
	}
	
	@Override
	public Relation<I, List<To>, To> getModel() {
		return (Relation<I, List<To>, To>) model;
	}
	
}
