package org.instantlogic.core.deduction;

import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.core.util.ValueAndLevel;

public abstract class Deduction<V extends Object> {
	
	public abstract ValueAndLevel<V> deduct(DeductionContext context);
	
}
