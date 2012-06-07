package org.instantlogic.interaction.util;

import java.util.Arrays;
import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowNodeBase;

public class FlowStack extends AbstractDeductionContext {
	
	public static FlowStack create(Flow mainFlow, String path, Instance caseInstance) {
		String[] pathElements = path.split("/");
		Iterator<String> iterator = Arrays.asList(pathElements).iterator();
		return mainFlow.createFlowStack(null, pathElements[0], iterator, caseInstance);
	}
	
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
	
	public String toPath() {
		StringBuilder result = new StringBuilder();
		if (parent!=null) {
			parent.toPath(result);
		}
		toPath(result);
		return result.toString();
	}
	
	void toPath(StringBuilder result) {
		result.append("/");
		result.append(this.flow.getName());
		for (Instance instance: selectedInstances) {
			result.append("/");
			result.append(instance.getMetadata().getInstanceId());
		}
	}
	
	@Override
	public String toString() {
		return "("+currentNode+" in "+flow+")"+(parent==null?"":"-->"+parent);
	}
}
