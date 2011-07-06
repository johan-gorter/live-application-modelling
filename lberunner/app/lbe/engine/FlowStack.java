package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.PageCoordinates.Coordinate;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;

public class FlowStack {
	
	private final FlowStack parent;
	
	private final Flow flow;
	
	private final List<Instance> activeInstances = new ArrayList<Instance>();
	
	private FlowNodeBase currentNode;

	public FlowStack(FlowStack parent, Flow flow) {
		this.parent = parent;
		this.flow = flow;
	}

	public FlowNodeBase getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(FlowNodeBase currentNode) {
		this.currentNode = currentNode;
	}

	public FlowStack getParent() {
		return parent;
	}

	public Flow getFlow() {
		return flow;
	}

	public List<Instance> getActiveInstances() {
		return activeInstances;
	}

	public void pushActiveInstance(Instance instance) {
		activeInstances.add(instance);
	}
	
	public Instance getActiveInstance(Entity entity) {
		for (int i=activeInstances.size()-1;i>=0;i--) {
			Instance candidate = activeInstances.get(i);
			if (candidate.getModel()==entity) {
				return candidate;
			}
		}
		if (parent!=null) {
			return parent.getActiveInstance(entity);
		}
		return null;
	}

	public PageCoordinates toPageCoordinates() {
		Coordinate lastCoordinate;
		PageCoordinates result;
		if (parent==null) {
			result = new PageCoordinates();
			lastCoordinate = new Coordinate(flow.getName(), new ArrayList<Long>());
			result.getPath().add(lastCoordinate);
		} else {
			result = parent.toPageCoordinates();
			lastCoordinate = result.getPath().get(result.getPath().size()-1);
		}
		for (Instance instance: activeInstances) {
			lastCoordinate.getActiveInstances().add(instance.getInstanceId());
		}
		result.addCoordinate(new Coordinate(currentNode.getName(), new ArrayList<Long>()));
		return result;
	}
}
