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
	public FlowEdge getEdge(FlowSource from) {
		for (FlowEdge edge: getEdges()) {
			if (edge.getFrom()==from) {
				return edge;
			}
		}
		return null;
	}
	
	public String flow(FlowSource flowSource, FlowContext context) {
		FlowEdge edge = getEdge(flowSource);
		FlowNodeBase node = edge.getTo();
		String event = node.flow(edge.getEntryName(), context);
		if (event!=null) {
			throw new RuntimeException("Not yet implemented");
		} else {
			return null;
		}
	}

	// This should result in a page.
	public void jumpTo(FlowContext flowContext) {
		jumpTo(flowContext, flowContext.getPageCoordinates().getPath().iterator());
		List<Coordinate> path = flowContext.getPageCoordinates().getPath();
		if (path.size()==0) {
			throw new RuntimeException("jumpTo did not reach a page");
		}
	}

	// This should result in a page.
	public void jumpTo(FlowContext flowContext, Iterator<Coordinate> coordinates) {
		if (!coordinates.hasNext()) {
			throw new RuntimeException("jumpTo did not reach a page");
		}
		Coordinate next = coordinates.next();
		for (FlowNodeBase node : getNodes()) {
			if (node.getName().equals(next.getNodeName())) {
				if (next.getActiveInstances()!=null) {
					flowContext.pushActiveInstances(next.getActiveInstances());
				}
				node.jumpTo(flowContext, coordinates);
			}
		}
	}
}
