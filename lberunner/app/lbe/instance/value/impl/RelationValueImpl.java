package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.model.Relation;

// To: Instance or List<Instance>
public class RelationValueImpl<I extends Instance, To extends Object> 
	extends AttributeValueImpl<I, To> 
	implements RelationValue<I, To>{

	private final Relation<I, To, ? extends Instance> model;
	private final I forInstance;

	public RelationValueImpl(I forInstance, Relation<I, To, ? extends Instance> model, boolean reverse) {
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
	
	public Relation<I, To, ? extends Instance> getModel() {
		return model;
	}
}
