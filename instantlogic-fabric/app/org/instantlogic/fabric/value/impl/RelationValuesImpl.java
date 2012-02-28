package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.RelationValues;


public class RelationValuesImpl<I extends Instance, To extends Instance>
	extends AttributeValuesImpl<I, To>
	implements RelationValues<I, To> {

	private Relation<I, Multi<To>, To> model;
	
	public RelationValuesImpl(I forInstance, Relation<I, Multi<To>, To> model) {
		super(forInstance, model);
		this.model = model;
	}
	
	@Override
	public Relation<I, Multi<To>, To> getModel() {
		return (Relation<I, Multi<To>, To>) model;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void fireChange(MultiValueUpdateType type, int index, To item, Operation operation) {
		super.fireChange(type, index, item, operation);
		if (type == MultiValueUpdateType.INSERT) {
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).addReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(forInstance, model.isOwner(), operation);
			}
		} else { // Remove
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).removeReverse(forInstance, operation);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(null, model.isOwner(), operation);
			}
		}
	}
	
}
