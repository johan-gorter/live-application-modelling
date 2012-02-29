package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Attribute;

public class AttributeDeduction<V, I extends Instance> extends Deduction<V> {

	public static <V, I extends Instance> AttributeDeduction<V, I> create(Attribute<I, V, ? extends Object> attribute, Deduction<I> input) {
		return new AttributeDeduction<V, I>(attribute, input);
	}
	
	private Deduction<I> instanceDeduction;
	private Attribute<I, V, ? extends Object> attribute;

	public AttributeDeduction(Attribute<I, V, ? extends Object> attribute, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.attribute = attribute;
	}

	@Override
	public V deduct(DeductionContext context) {
		return attribute.get(instanceDeduction.deduct(context)).get();
	}
}
