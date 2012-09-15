package org.instantlogic.fabric.value.impl;

import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;


public class ReverseRelationValueImpl<I extends Instance, From extends Instance>
	extends ReadOnlyRelationValueImpl<I, From>
	implements RelationValue<I, From>{

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

	void internalSetReverse(From reverseValue, Operation operation) {
		From oldValue = this.reverseValue;
		this.reverseValue = reverseValue;
		if (operation==null) return;
		fireValueChanged(ValueAndLevel.deducedOrMissing(oldValue), null, null, operation);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setValue(From newEntity) {
		if (newEntity==reverseValue) return;
		Relation<From,? extends Object,I> relation = ((Relation<I, From, From>)getModel()).getReverseRelation();
		if (reverseValue!=null) {
			// Remove forInstance from the old relation
			ReadOnlyAttributeValue<From, ? extends Object> value = relation.get(reverseValue);
			if (relation.isMultivalue()) {
				((RelationValues)value).removeValue(forInstance);
			} else {
				if (value.getValue()!=forInstance) {
					throw new RuntimeException("Reverse value not in sync while changing reverse relation");
				}
				((AttributeValue<From, ? extends Object>)value).setValue(null);
			}
		}
		if (reverseValue!=null) {
			throw new IllegalStateException("The reverse relation was not cleared from the other end");
		}
		if (newEntity!=null) {
			// Add forInstance to the new entity
			ReadOnlyAttributeValue<From, ? extends Object> value = (ReadOnlyAttributeValue<From, ? extends Object>)relation.get(newEntity);
			if (relation.isMultivalue()) {
				((RelationValues)value).addValue(forInstance);
			} else {
				if (value.getValue()!=forInstance) {
					throw new RuntimeException("Reverse value not in sync while changing reverse relation");
				}
				((AttributeValue)value).setValue(forInstance);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void clear() {
		if (reverseValue==null) return;
		Relation<From,? extends Object,I> relation = ((Relation<I, From, From>)getModel()).getReverseRelation();
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

	@Override
	public boolean isStored() {
		return reverseValue!=null;
	}
	
	@Override
	protected String valueToString() {
		return super.valueToString()+",reverseValue:"+reverseValue;
	}	
	
}
