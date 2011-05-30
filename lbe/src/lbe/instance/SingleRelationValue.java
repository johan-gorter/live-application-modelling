package lbe.instance;

import lbe.model.Relation;

public class SingleRelationValue<I extends Instance, To extends Instance> 
	extends AttributeValue<I, To> {

	private final Relation<I, To> model;
	private final I forInstance;

	private To value;

	public SingleRelationValue(I forInstance, Relation<I, To> model, boolean reverse) {
		super(forInstance, model);
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public To get() {
		if (model.isOwner() && value == null) {
			value = (To) model.createTo(forInstance);
		}
		return value;
	}
	
	public void set(To value) {
		this.value = value;
	}

	public Relation<I, To> getModel() {
		return model;
	}
}
