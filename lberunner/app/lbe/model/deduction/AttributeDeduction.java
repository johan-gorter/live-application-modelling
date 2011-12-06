package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Attribute;
import app.designer.AttributeBase;

public class AttributeDeduction<V, I extends Instance> extends Deduction<V> {

	private Deduction<I> instanceDeduction;
	private Attribute<I, V, ? extends Object> attribute;

	public AttributeDeduction(Deduction<I> instanceDeduction, Attribute<I, V, ? extends Object> attribute) {
		this.instanceDeduction = instanceDeduction;
		this.attribute = attribute;
	}

	@Override
	public V deduct(DeductionContext context) {
		return attribute.get(instanceDeduction.deduct(context)).get();
	}
}
