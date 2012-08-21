package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
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
	
	@Override
	public ValueAndLevel<To> getValueAndLevel() {
		ValueAndLevel<To> result = super.getValueAndLevel();
		if (!result.isConclusive() && model.isAutoCreate()) {
			// 1 on 1 aggregation, is now silently lazily created
			To resultValue = (To) model.createTo(forInstance);
			setStoredValue(resultValue);
			invalidateCachedValue();
			ReadOnlyAttributeValue<To, ? extends Object> newReverseRelationValue = model.getReverseRelation().get(resultValue);
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)newReverseRelationValue).addReverse(forInstance, null);
			} else {
				((ReverseRelationValueImpl)newReverseRelationValue).setReverse(forInstance, model.isOwner(), null);
			}
			forInstance.getMetadata().adopt(resultValue);
			return ValueAndLevel.stored(resultValue);
		}
		return result;
	}
	
	@Override
	protected void beforeFiringChange(ValueChangeEvent event) {
		if (model.getReverseRelation()==null) return;
		To oldStoredValue = (To) event.getOldStoredValue();
		To newStoredValue = (To) event.getNewStoredValue();
		Operation operation = event.getOperation();
		super.beforeFiringChange(event);
		if (oldStoredValue!=null) {
			ReadOnlyAttributeValue<To, ? extends Object> oldReverseRelationValue = model.getReverseRelation().get(oldStoredValue);
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)oldReverseRelationValue).removeReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)oldReverseRelationValue).setReverse(forInstance, model.isOwner(), operation);
			}
		}
		if (newStoredValue!=null) {
			ReadOnlyAttributeValue<To, ? extends Object> newReverseRelationValue = model.getReverseRelation().get(newStoredValue);
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)newReverseRelationValue).addReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)newReverseRelationValue).setReverse(forInstance, model.isOwner(), operation);
			}
		}
	}
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
