package org.instantlogic.core.deduction;

import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

/**
 * Used when the design contains an error and the generated code would not compile.
 * 
 * @param <V> The type of value to be returned
 */
public class InvalidDeduction<V> extends Deduction<V> {

	public static <V> InvalidDeduction<V> create() {
		return new InvalidDeduction<V>();
	}
	
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		return ValueAndLevel.inconclusive();
	}

}
