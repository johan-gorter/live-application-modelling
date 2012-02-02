package org.instantlogic.core.value.impl;

import java.util.List;

import org.instantlogic.core.Instance;
import org.instantlogic.core.impl.SimpleInstance;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.value.RelationValues;


public class RelationValuesImpl<I extends SimpleInstance<I>, To extends Instance<To>>
	extends AttributeValuesImpl<I, To>
	implements RelationValues<I, To> {

	private Relation<I, List<To>, To> model;
	
	public RelationValuesImpl(I forInstance, Relation<I, List<To>, To> model) {
		super(forInstance, model);
		this.model = model;
	}
	
	@Override
	public Relation<I, List<To>, To> getModel() {
		return (Relation<I, List<To>, To>) model;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void add(To item) {
		super.add(item);
		if (getModel().getReverseRelation().isMultivalue()) {
			((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).addReverse(forInstance);
		} else {
			((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(forInstance, model.isOwner());
		}
		
	};
	
}
