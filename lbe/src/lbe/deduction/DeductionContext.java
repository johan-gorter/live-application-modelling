package lbe.deduction;

import lbe.instance.Instance;

public class DeductionContext {
	
	// TODO: Case
	private final Instance fromInstance;

	public DeductionContext(Instance fromInstance) {
		this.fromInstance = fromInstance;
	}

	public Instance getFromInstance() {
		return fromInstance;
	}
}
