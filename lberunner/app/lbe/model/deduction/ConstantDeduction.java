package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;

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
