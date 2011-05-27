package lbe;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;

/**
 * Contains all attributes that have a user-set value. Not thread-safe, synchronize on Case.
 */
public class CaseData {
	private final int version;
	
	private List<Instance> activeInstances = new ArrayList<Instance>();

	public CaseData(Instance caseInstance, int version) {
		this.version = version;
		this.activeInstances.add(caseInstance);
	}

	public int getVersion() {
		return version;
	}

	public Instance getCaseInstance() {
		return activeInstances.get(0);
	}
	
	public void pushActiveInstance(Instance instance) {
		this.activeInstances.add(instance);
	}
	
	public void popActiveInstance(Instance instance) {
		if (this.activeInstances.size()<=1) {
			throw new RuntimeException("Asymmetric push/pop");
		}
		Instance removed = this.activeInstances.remove(this.activeInstances.size()-1);
		if (removed !=instance) {
			throw new RuntimeException("Asymmetric push/pop");
		}
	}
	
	@SuppressWarnings("unchecked")
	public <I extends Instance, Value extends Object> AttributeValue<I, Value> getValue(AttributeModel<I, Value> attribute) {
		EntityModel entity = attribute.getEntity();
		I instance = (I) getActiveInstance(entity);
		return (AttributeValue<I, Value>) attribute.get(instance);
	}

	private Instance getActiveInstance(EntityModel entity) {
		for (int i=activeInstances.size()-1;i>=0;i--) {
			Instance instance = activeInstances.get(i);
			if (instance.getModel()==entity) {
				return instance;
			}
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}
	
}
