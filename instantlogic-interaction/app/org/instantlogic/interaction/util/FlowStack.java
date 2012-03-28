package org.instantlogic.interaction.util;

import java.util.ArrayList;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;

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
			lastCoordinate = new Coordinate(flow.getName(), new ArrayList<String>());
			result.getPath().add(lastCoordinate);
		} else {
			result = parent.toPageCoordinates();
			lastCoordinate = result.getPath().get(result.getPath().size()-1);
		}
		for (Instance instance: selectedInstances) {
			lastCoordinate.getActiveInstances().add(instance.getMetadata().getInstanceId());
		}
		result.addCoordinate(new Coordinate(currentNode.getName(), new ArrayList<String>()));
		return result;
	}
	
	@Override
	public String toString() {
		return "("+currentNode+" in "+flow+")"+(parent==null?"":"-->"+parent);
	}
}
