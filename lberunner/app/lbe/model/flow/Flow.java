package lbe.model.flow;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import lbe.engine.FlowContext;
import lbe.engine.FlowStack;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Model;


public abstract class Flow extends Model {
	
	public abstract FlowNodeBase[] getNodes();
	public abstract FlowSource[] getSources();
	public abstract FlowSink[] getSinks();
	public abstract FlowEdge[] getEdges();

	/**
	 * Finds the page (pagePath is in the format subflowName.subflowName.pageName)
	 */
	public Page getPage(String[] path, int pathIndex) {
		for (FlowNodeBase node: getNodes()) {
			if (node.getName().equals(path[pathIndex])) {
				if (pathIndex==path.length-1) {
					return (Page) node;
				} else {
					return ((SubFlow)node).getFlow().getPage(path, pathIndex+1);
				}
			}
		}
		throw new RuntimeException("Page/Subflow not found: "+path[pathIndex]);
	}
	
	public FlowEdge getEdge(FlowNodeBase from, String trigger) {
		for (FlowEdge edge: getEdges()) {
			if (edge.getFrom()==from && edge.getEntryName().equals(trigger)) {
				return edge;
			}
		}
		return null;
	}
	
	private String enter(String trigger, FlowContext context) {
		throw new UnsupportedOperationException();
	}

	// Step to the next point in the flow. Updates context and results in the next trigger
	// returns null if a page has been reached.
	// TODO: use trigger
	public String step(FlowNodeBase flowSource, String trigger, Instance[] selectedInstances, FlowContext context) {
		if (flowSource==null && trigger == null) {
			FlowSource[] sources = getSources();
			if (sources.length!=1) {
				throw new RuntimeException("Can only start flows with 1 source, not "+getName());
			}
			flowSource = sources[0];
		}
		FlowEdge edge = getEdge(flowSource, trigger);
		FlowNodeBase node = edge.getTo();
		context.getFlowStack().setCurrentNode(node);
		if (node instanceof SubFlow) {
			return ((SubFlow)node).getFlow().enter(trigger, context);
		} else if (node instanceof Page) {
			return null;
		} else if (node instanceof FlowSink) {
			context.popFlowContext();
			return node.getName();
		} else {
			throw new RuntimeException("Edge did not reach something useful "+node);
		}
	}

	public FlowStack createFlowStack(FlowStack stack, Coordinate current, Iterator<Coordinate> moreCoordinates, CaseInstance caseInstance) {
		if (current.getActiveInstances()!=null) {
			for (Long instanceId: current.getActiveInstances()) {
				Instance instance = caseInstance.getInstanceById(instanceId);
				stack.pushSelectedInstance(instance);
			}
		}
		if (moreCoordinates.hasNext()) {
			Coordinate next = moreCoordinates.next();
			FlowNodeBase nextNode = getNode(next.getNodeName());
			stack.setCurrentNode(nextNode);
			if (nextNode instanceof SubFlow) {
				return ((SubFlow)nextNode).getFlow().createFlowStack(stack, next, moreCoordinates, caseInstance);
			}
		}
		return stack;
	}
	
	private FlowNodeBase getNode(String nodeName) {
		for (FlowNodeBase node: getNodes()) {
			if (node.getName().equals(nodeName)) {
				return node;
			}
		}
		throw new NoSuchElementException("Node: "+nodeName);
	}
}
