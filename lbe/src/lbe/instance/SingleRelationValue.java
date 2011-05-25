package lbe.instance;

import lbe.model.RelationModel;

public class SingleRelationValue<I extends Instance> 
	extends AttributeValue<I> {

	private final RelationModel<I> model;
	private final boolean reverse;

	private I value;
	private Instance forInstance;

	public SingleRelationValue(Instance forInstance, RelationModel<I> model, boolean reverse) {
		super(forInstance, model);
		this.model = model;
		this.reverse = reverse;
	}
	
	@SuppressWarnings("unchecked")
	public I get() {
		if (!reverse && model.isOwner() && value == null) {
			value = (I) model.createTo(forInstance);
		}
		return value;
	}
	
	public void set(I value) {
		this.value = value;
	}

	public RelationModel<I> getModel() {
		return model;
	}
}
