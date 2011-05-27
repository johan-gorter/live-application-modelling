package lbe.instance;

import lbe.model.RelationModel;

public class SingleRelationValue<I extends Instance, To extends Instance> 
	extends AttributeValue<I, To> {

	private final RelationModel<I, To> model;
	private final boolean reverse;
	private final I forInstance;

	private To value;

	public SingleRelationValue(I forInstance, RelationModel<I, To> model, boolean reverse) {
		super(forInstance, model);
		this.forInstance = forInstance;
		this.model = model;
		this.reverse = reverse;
	}
	
	public To get() {
		if (!reverse && model.isOwner() && value == null) {
			value = (To) model.createTo(forInstance);
		}
		return value;
	}
	
	public void set(To value) {
		this.value = value;
	}

	public RelationModel<I, To> getModel() {
		return model;
	}
}
