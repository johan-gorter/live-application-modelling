package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Model;

public abstract class Deduction<V extends Object> {
	
	public abstract V deduct(DeductionContext context);
	
}
