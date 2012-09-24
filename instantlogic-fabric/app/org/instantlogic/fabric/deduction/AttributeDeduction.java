package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeDeduction<V, I extends Instance> extends Deduction<V> {

	public static <V, I extends Instance> AttributeDeduction<V, I> create(Attribute<I, V, ? extends Object> attribute, Deduction<? extends I> input) {
		return new AttributeDeduction<V, I>(attribute, input);
	}
	
	private Deduction<? extends I> instanceDeduction;
	private Attribute<I, V, ? extends Object> attribute;

	public AttributeDeduction(Attribute<I, V, ? extends Object> attribute, Deduction<? extends I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.attribute = attribute;
	}

	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<? extends I> instanceValue = instanceDeduction.deduct(context);
		if (instanceValue.getValue()==null) {
			throw new RuntimeException("No instance while getting value for attribute "+attribute+" on entity "+attribute.getEntity()+", context: "+context.printDiagnostics());//TODO: reconsider if returning inconclusive might be more appropriate
		}
		return attribute.get(instanceValue.getValue()).getValueAndLevel();
	}
}
