package org.instantlogic.interaction.flow;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Concept;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;


public abstract class Flow extends Concept {
	
	public abstract FlowNodeBase[] getNodes();
	public abstract FlowSource[] getSources();
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
	
	public FlowEdge findEdge(FlowNodeBase from, FlowEventOccurrence occurrence) {
		for (FlowEdge edge: getEdges()) {
			if (edge.getStartNode()==from && occurrence.getEvent()==edge.getStartEvent()) {
				return edge;
			}
		}
		return null;
	}
	
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FlowSource source = findSource(occurrence.getEvent());
		context.pushFlowContext(this);
		acceptParameters(context, occurrence.getParameters());
		if (source.getEndNode()==null) {
			return occurrence; // Pop the event, because this source does not reach anything
		} else {
			return reach(source.getEndEvent(), source.getEndNode(), occurrence, context);
		}
	}
	
	private FlowEventOccurrence nextOccurrence(FlowEventOccurrence occurrence, FlowEvent newEvent) {
		return new FlowEventOccurrence(newEvent, occurrence.getParameters()); // todo: pick the right parameters
	}
	
	private FlowSource findSource(FlowEvent event) {
		FlowSource defaultSource = null;
		FlowSource[] sources = getSources();
		for (FlowSource source: sources) {
			if (source.getStartEvent()==null) {
				defaultSource = source;
				continue;
			}
			if (source.getStartEvent()==event) return source;
		}
		if (defaultSource!=null) return defaultSource;
		throw new RuntimeException("Flow "+getName()+" does not have a source for event: "+event.getName());
	}
	
	protected void acceptParameters(FlowContext context, Instance[] selectedInstances) {
		nextParameter: for (Entity entity : this.getParameters()) {
			for (Instance instance: selectedInstances) {
				if (Entity.extendsFrom(instance.getInstanceEntity(), entity)) {
					context.getFlowStack().pushSelectedInstance(instance);
					continue nextParameter;
				}
			}
			throw new RuntimeException("No instance selected which matches parameter "+entity.getName());
		}
	}

	// Step to the next point in the flow. Updates context and results in the next trigger
	// returns null if a page has been reached.
	public FlowEventOccurrence step(FlowNodeBase flowNode, FlowEventOccurrence occurrence, FlowContext context) {
		FlowEdge edge = findEdge(flowNode, occurrence);
		if (edge==null) { // No edge at this level, pop to the flow above and check again
			context.popFlowContext();
			return occurrence;
		}
		return reach(edge.getEndEvent(), edge.getEndNode(), occurrence, context);
	}

	// The end of an edge or source has been reached
	private FlowEventOccurrence reach(FlowEvent endEvent, FlowNodeBase node, FlowEventOccurrence occurrence, FlowContext context) {
		if (endEvent!=null) {
			occurrence = nextOccurrence(occurrence, endEvent);
		}
		context.getFlowStack().setCurrentNode(node);
		context.logOccurrence(occurrence);
		if (node instanceof SubFlow) {
			return ((SubFlow)node).getFlow().enter(occurrence, context);
		} else if (node instanceof Page) {
			return null;
		} else {
			throw new RuntimeException("Edge did not reach something useful "+node);
		}
	}
	
	public FlowStack createFlowStack(FlowStack stack, Coordinate current, Iterator<Coordinate> moreCoordinates, Instance caseInstance) {
		stackSelectedInstances(stack, current, caseInstance);
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
	
	protected void stackSelectedInstances(FlowStack stack, Coordinate current, Instance caseInstance) {
		if (current.getActiveInstances().size()!=this.getParameters().length) {
			throw new RuntimeException("Number of parameters does not match number of selected instances"); // TODO check if the right instances are selected
		}
		for (String instanceId: current.getActiveInstances()) {
			Instance instance = caseInstance.getInstanceAdministration().getInstanceById(instanceId);
			if (instance==null) {
				throw new RuntimeException("Instance "+instanceId+" invalid");
			}
			stack.pushSelectedInstance(instance);
		}
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
