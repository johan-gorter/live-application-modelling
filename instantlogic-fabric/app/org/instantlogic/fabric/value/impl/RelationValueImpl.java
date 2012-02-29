package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.RelationValue;


public class RelationValueImpl<I extends Instance, To extends Instance> 
	extends AttributeValueImpl<I, To> 
	implements RelationValue<I, To>{

	private final Relation<I, To, To> model;
	private final I forInstance;

	public RelationValueImpl(I forInstance, Relation<I, To, To> model) {
		super(forInstance, model);
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public To getValue() {
		To result = super.getValue();
		if (result == null && model.isAutoCreate()) {
			// 1 on 1 aggregation, is now lazily created
			result = (To) model.createTo(forInstance);
			setStoredValue(result);
			invalidateCachedValue();
			forInstance.adopt(result);
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void fireValueChanged(ValueAndLevel<To> oldValue, To oldStoredValue, To newStoredValue, Operation operation) {
		super.fireValueChanged(oldValue, oldStoredValue, newStoredValue, operation);
		if (oldStoredValue!=null) {
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(oldStoredValue)).removeReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(oldStoredValue)).setReverse(forInstance, model.isOwner(), operation);
			}
		}
		if (newStoredValue!=null) {
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(newStoredValue)).addReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(newStoredValue)).setReverse(forInstance, model.isOwner(), operation);
			}
		}
	};
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
