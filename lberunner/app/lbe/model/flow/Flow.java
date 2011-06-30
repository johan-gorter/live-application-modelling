package lbe.model.flow;

import java.util.Iterator;
import java.util.List;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;
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
	
	public FlowEdge getEdge(FlowNodeBase from) {
		for (FlowEdge edge: getEdges()) {
			if (edge.getFrom()==from) {
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
	public String flow(FlowNodeBase flowSource, String trigger, FlowContext context) {
		if (flowSource==null) {
			FlowSource[] sources = getSources();
			if (sources.length!=1) {
				throw new RuntimeException("Can only start flows with 1 source, not "+getName());
			}
			flowSource = sources[0];
		}
		FlowEdge edge = getEdge(flowSource);
		FlowNodeBase node = edge.getTo();
		if (node instanceof SubFlow) {
			return ((SubFlow)node).getFlow().enter(trigger, context);
		} else if (node instanceof Page) {
			((Page)node).enter(context);
			return null;
		} else if (node instanceof FlowSink) {
			return node.getName();
		} else {
			throw new RuntimeException("Edge did not reach something useful "+node);
		}
	}

	// This should result in a page.
	public void jumpTo(FlowContext flowContext, Coordinate thisCoordinate, Iterator<Coordinate> coordinates) {
		if (thisCoordinate.getActiveInstances()!=null) {
			flowContext.pushActiveInstances(thisCoordinate.getActiveInstances());
		}
		if (!coordinates.hasNext()) {
			throw new RuntimeException("jumpTo did not reach a page");
		}
		Coordinate next = coordinates.next();
		for (FlowNodeBase node : getNodes()) {
			if (node.getName().equals(next.getNodeName())) {
				node.jumpTo(flowContext, next, coordinates);
			}
		}
	}
}
