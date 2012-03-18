package org.instantlogic.fabric.value.impl;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;


public class ReverseRelationValueImpl<I extends Instance, From extends Instance>
	extends ReadOnlyRelationValueImpl<I, From>
	implements ReadOnlyRelationValue<I, From>{

	private From reverseValue;
	
	public ReverseRelationValueImpl(I forInstance, Relation<I, From, From> model) {
		super(forInstance, model);
	}
	
	@Override
	public ValueAndLevel<From> getValueAndLevel() {
		return ValueAndLevel.deducedOrInconclusive(reverseValue);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Relation<I, From, From> getModel() {
		return (Relation<I, From, From>) super.getModel();
	}

	public void setReverse(From reverseValue, boolean isOwner, Operation operation) {
		From oldValue = this.reverseValue;
		this.reverseValue = reverseValue;
		if (operation==null) return;
		if (isOwner) {
			if (oldValue!=null) {
				oldValue.getMetadata().reject(forInstance);
			}
			if (reverseValue!=null) {
				reverseValue.getMetadata().adopt(forInstance);
			}
		}
		fireValueChanged(ValueAndLevel.deducedOrMissing(oldValue), null, null, operation);
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
			value.setValue(null);
		}
		if (!result) throw new RuntimeException("Reverse value not in sync while clearing reverse relation");
	}
}
