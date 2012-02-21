package org.instantlogic.interaction.flow;


public class FlowEdge {
	
	private FlowNodeBase startNode;
	private FlowEvent startEvent;
	
	private FlowNodeBase endNode;
	private FlowEvent endEvent;
	
	
	/**
	 * Creates a new FlowEdge
	 * @param startNode required: node the edge starts from
	 * @param startEvent required: event the edge triggers on
	 * @param endNode required: node the edge ends in
	 * @param endEvent optional: event that is used to select the source to use in the target node
	 */
	public FlowEdge(FlowNodeBase startNode, FlowEvent startEvent, FlowNodeBase endNode, FlowEvent endEvent) {
		this.startNode = startNode;
		this.startEvent = startEvent;
		this.endNode = endNode;
		this.endEvent = endEvent;
	}
	
	public FlowNodeBase getStartNode() {
		return startNode;
	}

	public FlowEvent getStartEvent() {
		return startEvent;
	}

	public FlowNodeBase getEndNode() {
		return endNode;
	}

	public FlowEvent getEndEvent() {
		return endEvent;
	}
}
