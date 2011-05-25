package lbe.deduction;

public abstract class Deduction<V extends Object>  {
	
	public abstract V deduct(DeductionContext context);
}
