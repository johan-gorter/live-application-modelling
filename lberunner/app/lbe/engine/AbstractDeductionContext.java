package lbe.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lbe.instance.Instance;
import lbe.model.Entity;

/**
 *	Used to calculate deductions by keeping a list of selected instances. 
 */
public abstract class AbstractDeductionContext extends DeductionContext {

	protected final List<Instance> selectedInstances = new ArrayList<Instance>();
	
	private final DeductionContext parent;
	
	public AbstractDeductionContext(DeductionContext parent) {
		this.parent = parent;
	}

	public Instance getSelectedInstance(Entity entity) {
		for (int i=selectedInstances.size()-1;i>=0;i--) {
			Instance candidate = selectedInstances.get(i);
			if (Entity.extendsFrom(candidate.getModel(), entity)) {
				return candidate;
			}
		}
		if (parent!=null) {
			return parent.getSelectedInstance(entity);
		}
		return null;
	}

	public void pushSelectedInstance(Instance instance) {
		selectedInstances.add(instance);
	}
	
	public Instance popSelectedInstance() {
		if (this.selectedInstances.size()==0) {
			throw new RuntimeException("Asymmetric push/pop");
		}
		return selectedInstances.remove(selectedInstances.size()-1);
	}

	public void popSelectedInstance(Instance instance) {
		Instance check = popSelectedInstance();
		if (check!=instance) {
			throw new RuntimeException("Asymmetric push/pop");
		}
	}
	
	protected void addSelectedInstances(List<Instance> result) {
		ListIterator<Instance> iterator = selectedInstances.listIterator(selectedInstances.size());
		while (iterator.hasPrevious()) {
			result.add(iterator.previous());
		}
		if (parent!=null) {
			parent.addSelectedInstances(result);
		}
	}
	
}
