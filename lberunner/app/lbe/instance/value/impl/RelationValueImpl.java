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
		To result = super.get();
		if (result == null && model.isAutoCreate()) {
			// 1 on 1 aggregation, is now lazily created
			result = (To) model.createTo(forInstance);
			set(result);
		}
		return result;
	}
	
	@Override
	public void set(To value) {
		To previous = super.get();
		if (previous == value) return;
		super.set(value);
		if (previous!=null) {
			throw new RuntimeException("Not yet implemented");
		}
		if (value!=null) {
			if (getModel().getReverseRelation().isMultivalue()) {
				((ReverseRelationValuesImpl)model.getReverseRelation().get(value)).addReverse(forInstance);
			} else {
				((ReverseRelationValueImpl)model.getReverseRelation().get(value)).setReverse(forInstance);
			}
		}
	};
	
	public Relation<I, To, To> getModel() {
		return model;
	}
}
