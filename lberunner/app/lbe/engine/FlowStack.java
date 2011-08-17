package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.PageCoordinates.Coordinate;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;

public class FlowStack extends AbstractDeductionContext {
	
	private final FlowStack parent;
	
	private final Flow flow;
	
	private FlowNodeBase currentNode;

	public FlowStack(FlowStack parent, Flow flow) {
		super(parent);
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
		for (Instance instance: selectedInstances) {
			lastCoordinate.getActiveInstances().add(instance.getInstanceId());
		}
		result.addCoordinate(new Coordinate(currentNode.getName(), new ArrayList<Long>()));
		return result;
	}
}
