package lbe.model.deduction;

import lbe.engine.DeductionContext;

/**
 * Used when the design contains an error and the generated code would not compile.
 * 
 * @param <V> The type of value to be returned
 */
public class InvalidDeduction<V> extends Deduction<V> {

	@Override
	public V deduct(DeductionContext context) {
		return null;
	}

}
