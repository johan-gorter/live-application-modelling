package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.value.RelationValue;


public class RelationValueImpl<I extends Instance, To extends Instance> 
	extends AttributeValueImpl<I, To> 
	implements RelationValue<I, To>{

	private final Relation<I, To, To> model;
	private final I forInstance;
	private boolean suppressValueChanged;

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
			this.suppressValueChanged = true;
			setValue(result);
			this.suppressValueChanged = false;
		}
		return result;
	}
	
	@Override
	protected void fireEvent(ValueChangeEvent event) {
		if (!suppressValueChanged) {
			super.fireEvent(event);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setValue(To value) {
		To previous = super.getValue();
		if (previous == value) return;
		super.setValue(value);
		if (previous!=null) {
			throw new RuntimeException("Not yet implemented");
		}
		if (value!=null) {
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(value)).addReverse(forInstance);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(value)).setReverse(forInstance, model.isOwner());
			}
		}
	};
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
