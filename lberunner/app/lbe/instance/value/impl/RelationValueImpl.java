package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.model.Relation;

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
	
	public To get() {
		if (model.isOwner() && !isStored() && !model.isMultivalue()) {
			// 1 on 1 relation, is now lazily created
			set((To) model.createTo(forInstance));
		}
		return super.get();
	}
	
	@Override
	public void set(To value) {
		super.set(value);
		if (getModel().getReverseRelation().isMultivalue()) {
			((ReverseRelationValuesImpl)model.getReverseRelation().get(value)).addReverse(forInstance);
		} else {
			((ReverseRelationValueImpl)model.getReverseRelation().get(value)).setReverse(forInstance);
		}
	};
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
