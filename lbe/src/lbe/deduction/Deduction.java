package lbe.deduction;

import lbe.instance.Instance;

public abstract class Deduction<V extends Object>  {
	
	public abstract V deduct(Instance forInstance);
}
