package org.instantlogic.core.deduction;


import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

public class AttributeDeduction<V, I extends Instance<I>> extends Deduction<V> {

	public static <V, I extends Instance<I>> AttributeDeduction<V, I> create(Attribute<I, V, ? extends Object> attribute, Deduction<I> input) {
		return new AttributeDeduction<V, I>(attribute, input);
	}
	
	private Deduction<I> instanceDeduction;
	private Attribute<I, V, ? extends Object> attribute;

	public AttributeDeduction(Attribute<I, V, ? extends Object> attribute, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.attribute = attribute;
	}

	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<I> instanceValue = instanceDeduction.deduct(context);
		if (instanceValue.getValue()==null) {
			throw new RuntimeException("No instance");//TODO: reconsider if returning inconclusive might be more appropriate
		}
		return attribute.get(instanceValue.getValue()).getValueAndLevel();
	}
}
