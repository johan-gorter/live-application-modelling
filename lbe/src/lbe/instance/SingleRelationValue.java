package lbe.instance;

import lbe.model.Relation;

public class SingleRelationValue<I extends Instance, To extends Instance> 
	extends AttributeValue<I, To> {

	private final Relation<I, To> model;
	private final I forInstance;

	public SingleRelationValue(I forInstance, Relation<I, To> model, boolean reverse) {
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
