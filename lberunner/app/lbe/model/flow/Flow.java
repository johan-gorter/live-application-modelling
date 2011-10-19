package lbe.model.flow;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import freemarker.template.utility.StringUtil;

import lbe.engine.FlowContext;
import lbe.engine.FlowStack;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.Model;


public abstract class Flow extends Model {
	
	public abstract FlowNodeBase[] getNodes();
	public abstract FlowSource[] getSources();
	public abstract FlowSink[] getSinks();
	public abstract FlowEdge[] getEdges();
	public abstract Entity[] getParameters();

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
			if (edge.getFrom()==from && trigger.equals(edge.getExitName())) {
				return edge;
			}
		}
		throw new RuntimeException("Could not find edge with exitName "+trigger+" in flow "+this.getName()+" from node "+from.getName());
	}
	
	public String enter(String trigger, FlowContext context, Instance[] selectedInstances) {
		for (FlowSource source: getSources()) {
			if (source.getName().equals(trigger)) {
				context.pushFlowContext(this);
				nextParameter: for (Entity entity : this.getParameters()) {
					for (Instance instance: selectedInstances) {
						if (Entity.extendsFrom(instance.getModel(), entity)) {
							context.getFlowStack().pushSelectedInstance(instance);
							continue nextParameter;
						}
					}
					throw new RuntimeException("No instance selected which matches parameter "+entity.getName());
				}
				return step(source, "start", selectedInstances, context);
			}
		}
		throw new RuntimeException("Could not find flow source with name: "+trigger);
	}

	// Step to the next point in the flow. Updates context and results in the next trigger
	// returns null if a page has been reached.
	public String step(FlowNodeBase flowSource, String trigger, Instance[] selectedInstances, FlowContext context) {
		FlowEdge edge = getEdge(flowSource, trigger);
		FlowNodeBase node = edge.getTo();
		context.getFlowStack().setCurrentNode(node);
		if (node instanceof SubFlow) {
			return ((SubFlow)node).getFlow().enter(trigger, context, selectedInstances);
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
		if (current.getActiveInstances().size()!=this.getParameters().length) {
			throw new RuntimeException("Number of parameters does not match number of selected instances"); // TODO check if the right instances are selected
		}
		for (Long instanceId: current.getActiveInstances()) {
			Instance instance = caseInstance.getInstanceById(instanceId);
			if (instance==null) {
				throw new RuntimeException("Instance "+instanceId+" invalid");
			}
			stack.pushSelectedInstance(instance);
		}
		if (moreCoordinates.hasNext()) {
			Coordinate next = moreCoordinates.next();
			FlowNodeBase nextNode = getNode(next.getNodeName());
			stack.setCurrentNode(nextNode);
			if (nextNode instanceof SubFlow) {
				Flow flow = ((SubFlow)nextNode).getFlow(); 
				stack = new FlowStack(stack, flow);
				return flow.createFlowStack(stack, next, moreCoordinates, caseInstance);
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
