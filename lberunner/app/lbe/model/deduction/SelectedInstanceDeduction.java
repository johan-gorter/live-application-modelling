package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Entity;

public class SelectedInstanceDeduction<V extends Instance> extends Deduction<V> {

	private Entity entity;

	public SelectedInstanceDeduction(Entity entity) {
		this.entity = entity;
	}
	
	@Override
	public V deduct(DeductionContext context) {
		return (V)context.getSelectedInstance(entity); // Will throw an exception if no such entity is selected. (This should have been validated at design time)
	}

}
