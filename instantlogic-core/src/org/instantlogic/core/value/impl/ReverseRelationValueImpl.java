package org.instantlogic.core.value.impl;

import java.util.List;

import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValue;


public class ReverseRelationValueImpl<I extends SimpleInstance<I>, From extends Instance<From>>
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
			((SimpleInstance<?>)forInstance).registerOwner((SimpleInstance<?>)reverseValue);
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
