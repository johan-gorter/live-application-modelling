package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.model.Attribute;
import lbe.model.Relation;

public class ReverseRelationValueImpl<I extends Instance, From extends Instance>
	extends ReadOnlyRelationValueImpl<I, From>
	implements ReadOnlyRelationValue<I, From>{

	private From reverseValue;
	
	public ReverseRelationValueImpl(I forInstance, Relation<I, From, From> model) {
		super(forInstance, model);
	}
	
	@Override
	public From get() {
		return reverseValue;
	}

	@Override
	public Relation<I, From, From> getModel() {
		return (Relation<I, From, From>) super.getModel();
	}

	public void setReverse(From reverseValue) {
		this.reverseValue = reverseValue;
	}
}
