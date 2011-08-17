package lbe.engine;

import lbe.instance.Instance;
import lbe.model.Entity;

public class SingleInstanceDeductionContext extends DeductionContext {

	private final Instance instance;
	
	public SingleInstanceDeductionContext(Instance instance) {
		this.instance = instance;
	}

	@Override
	public Instance getSelectedInstance(Entity entity) {
		if (instance.getModel()==entity) {
			return instance;
		}
		return null;
	}

}
