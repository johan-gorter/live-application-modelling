package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
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
	protected void beforeFiringChange(ValueChangeEvent event) {
		MultiValueUpdateType type = event.getMultiValueUpdateType();
		To item = (To) event.getItemValue();
		Operation operation = event.getOperation();
		if (model.isOwner()) {
			if (type == MultiValueUpdateType.INSERT) {
				forInstance.getMetadata().adopt(item);
			} else { // Remove
				forInstance.getMetadata().reject(item);
			}
		}
		super.beforeFiringChange(event);
		if (model.getReverseRelation()!=null) {
			if (type == MultiValueUpdateType.INSERT) {
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).addReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(forInstance, operation);
				}
			} else { // Remove
				if (getModel().getReverseRelation().isMultivalue()) {
					((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).removeReverse(forInstance, operation);
				} else {
					((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(null, operation);
				}
			}
		}
	};
}
