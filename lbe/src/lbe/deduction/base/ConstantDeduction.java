package lbe.deduction.base;

import lbe.deduction.Deduction;
import lbe.deduction.DeductionContext;

public class ConstantDeduction<V> extends Deduction<V> {

	private final V constant;
	
	public ConstantDeduction(V constant) {
		this.constant = constant;
	}

	@Override
	public V deduct(DeductionContext context) {
		return constant;
	}

	
}
