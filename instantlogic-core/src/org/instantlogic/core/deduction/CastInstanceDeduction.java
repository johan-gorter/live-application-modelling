package org.instantlogic.core.deduction;


import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

// If the input is the specified subclass, the input is returned, otherwise null is returned 
public class CastInstanceDeduction<I extends Instance<I>, V extends Instance<V>> extends Deduction<V> { // V extends I

	public static <I extends Instance<I>, V extends Instance<V>> CastInstanceDeduction<I, V> create(Entity<V> entity, Deduction<I> instanceDeduction) {
		return new CastInstanceDeduction<I, V>(entity, instanceDeduction);
	}
	
	private Deduction<I> instanceDeduction;
	private Entity<V> toEntity;

	public CastInstanceDeduction(Entity<V> toEntity, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.toEntity = toEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<I> candidate = instanceDeduction.deduct(context);
		if (Entity.extendsFrom(candidate.getValue().getModel(), toEntity)) {
			return ValueAndLevel.deduced((V)candidate.getValue());
		}
		return null;
	}
}
