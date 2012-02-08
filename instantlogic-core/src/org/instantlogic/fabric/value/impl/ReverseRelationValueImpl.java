package org.instantlogic.fabric.value.impl;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;


public class ReverseRelationValueImpl<I extends Instance<I>, From extends Instance<From>>
	extends ReadOnlyRelationValueImpl<I, From>
	implements ReadOnlyRelationValue<I, From>{

	private From reverseValue;
	
	public ReverseRelationValueImpl(I forInstance, Relation<I, From, From> model) {
		super(forInstance, model);
	}
	
	@Override
	public From getValue() {
		return reverseValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Relation<I, From, From> getModel() {
		return (Relation<I, From, From>) super.getModel();
	}

	public void setReverse(From reverseValue, boolean isOwner) {
		this.reverseValue = reverseValue;
		if (isOwner) {
			reverseValue.adopt(forInstance);
		}
	}
	
	public void clear() {
		if (reverseValue==null) return;
		Relation<From,? extends Object,I> relation = ((Relation<I, From, From>)model).getReverseRelation();
		AttributeValue<From, ? extends Object> value = (AttributeValue<From, ? extends Object>)relation.get(reverseValue);
		boolean result = false;
		if (relation.isMultivalue()) {
			result = ((List)value).remove(forInstance);
		} else {
			result = value.getValue()==forInstance;
			value.set(null);
		}
		if (!result) throw new RuntimeException("Reverse value not in sync while clearing reverse relation");
	}
}
