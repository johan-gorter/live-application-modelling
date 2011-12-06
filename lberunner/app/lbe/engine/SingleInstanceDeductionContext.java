package lbe.engine;

import java.util.List;

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
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	@Override
	protected void addSelectedInstances(List<Instance> result) {
		result.add(instance);
	}

}
