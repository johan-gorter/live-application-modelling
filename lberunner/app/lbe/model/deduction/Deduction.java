package lbe.model.deduction;

import lbe.instance.Instance;
import lbe.model.Model;

public abstract class Deduction<V extends Object> extends Model {
	
	public abstract V deduct(Instance forInstance);
	
	@Override
	public String getName() {
		return null;
	}
}
