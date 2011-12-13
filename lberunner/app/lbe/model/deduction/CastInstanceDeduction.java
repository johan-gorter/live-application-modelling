package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;

// If the input is the specified subclass, the input is returned, otherwise null is returned 
public class CastInstanceDeduction<I extends Instance, V extends I> extends Deduction<V> {

	public static <I extends Instance, V extends I> CastInstanceDeduction<I, V> create(Entity entity, Deduction<I> instanceDeduction) {
		return new CastInstanceDeduction<I, V>(entity, instanceDeduction);
	}
	
	private Deduction<I> instanceDeduction;
	private Entity entity;

	public CastInstanceDeduction(Entity entity, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.entity = entity;
	}

	@Override
	public V deduct(DeductionContext context) {
		I candidate = instanceDeduction.deduct(context);
		if (Entity.extendsFrom(candidate.getModel(), entity)) {
			return (V)candidate;
		}
		return null;
	}
}
