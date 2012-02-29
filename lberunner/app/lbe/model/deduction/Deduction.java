package lbe.model.deduction;

import lbe.engine.DeductionContext;

public abstract class Deduction<V extends Object> {
	
	public abstract V deduct(DeductionContext context);
	
}
