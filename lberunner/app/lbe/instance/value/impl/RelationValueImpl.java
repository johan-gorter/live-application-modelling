package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.model.Relation;

public class RelationValueImpl<I extends Instance, To extends Instance> 
	extends AttributeValueImpl<I, To> {

	private final Relation<I, To> model;
	private final I forInstance;

	public RelationValueImpl(I forInstance, Relation<I, To> model, boolean reverse) {
		super(forInstance, model);
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public To get() {
		if (model.isOwner() && !isStored()) {
			set((To) model.createTo(forInstance));
		}
		return super.get();
	}
	
	public Relation<I, To> getModel() {
		return model;
	}
}
