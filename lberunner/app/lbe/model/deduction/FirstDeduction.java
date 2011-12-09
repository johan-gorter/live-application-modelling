package lbe.model.deduction;

import lbe.engine.DeductionContext;

public class FirstDeduction<V> extends Deduction<V> {

	public static <V> FirstDeduction<V> create(Deduction<V>... inputs) {
		return new FirstDeduction<V>(inputs);
	}
	
	private Deduction<V>[] inputs;

	public FirstDeduction(Deduction<V>... inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public V deduct(DeductionContext context) {
		for(Deduction<V> input: inputs) {
			V result = input.deduct(context);
			if (result!=null) return result;
		}
		return null;
	}
}
