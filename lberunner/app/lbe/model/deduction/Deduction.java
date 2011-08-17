package lbe.model.deduction;

import lbe.engine.DeductionContext;
import lbe.instance.Instance;
import lbe.model.Model;

public abstract class Deduction<V extends Object> extends Model {
	
	public abstract V deduct(DeductionContext context);
	
	@Override
	public String getName() {
		return null;
	}
}
