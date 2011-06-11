package lbe.instance.value.impl;

import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.RelationValues;
import lbe.model.Relation;

public class RelationValuesImpl<I extends Instance, To extends Instance>
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
	
	@Override
	public void add(To item) {
		super.add(item);
		if (getModel().getReverseRelation().isMultivalue()) {
			((ReverseRelationValuesImpl)model.getReverseRelation().get(item)).addReverse(forInstance);
		} else {
			((ReverseRelationValueImpl)model.getReverseRelation().get(item)).setReverse(forInstance);
		}
		
	};
	
}
