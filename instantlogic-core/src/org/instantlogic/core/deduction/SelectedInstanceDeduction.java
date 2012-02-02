package org.instantlogic.core.deduction;


import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

public class SelectedInstanceDeduction<V extends Instance<V>> extends Deduction<V> {

	public static <V extends Instance<V>> SelectedInstanceDeduction<V> create(Entity<V> entity) {
		return new SelectedInstanceDeduction<V>(entity);
	}
	
	private Entity<V> ofEntity;

	public SelectedInstanceDeduction(Entity<V> entity) {
		this.ofEntity = entity;
	}
	
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		return ValueAndLevel.deduced((V)context.getSelectedInstance(ofEntity)); // Will throw an exception if no such entity is selected. (This should have been validated at design time)
	}

}
