package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public abstract class Deduction<V extends Object> {
	
	public abstract ValueAndLevel<V> deduct(DeductionContext context);
	
}
