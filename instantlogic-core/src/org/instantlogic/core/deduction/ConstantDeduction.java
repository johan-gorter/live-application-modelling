package org.instantlogic.core.deduction;

import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

public class ConstantDeduction<V> extends Deduction<V> {

	public static <V> ConstantDeduction<V> create(V constant) {
		return new ConstantDeduction<V>(constant);
	}
	
	private final ValueAndLevel<V> constant;
	
	public ConstantDeduction(V constant) {
		this.constant = ValueAndLevel.deduced(constant);
	}

	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		return constant;
	}

	
}
