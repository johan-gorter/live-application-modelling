package lbe.model.flow;

import lbe.model.Model;


public abstract class Flow extends Model {
	
	/**
	 * Source as in a graph with source and sinks.
	 * 
	 * @return
	 */
	public abstract FlowNodeBase getStart();
	public abstract FlowNodeBase[] getNodes();
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
}
