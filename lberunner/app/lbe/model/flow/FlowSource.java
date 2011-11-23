package lbe.model.flow;

import java.util.Iterator;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.model.FlowEvent;

public class FlowSource {
	
	private FlowEvent startEvent;
	
	private FlowNodeBase endNode;
	
	private FlowEvent endEvent;

	/**
	 * Creates a new FlowSource
	 * 
	 * @param startEvent optional: Event that triggers this source. Null lets every event enter at this source.
	 * @param endNode optional: node the edge ends in
	 * @param endEvent optional: event that is used to select the source to use in the target node
	 */
	public FlowSource(FlowEvent startEvent, FlowNodeBase endNode, FlowEvent endEvent) {
		this.startEvent = startEvent;
		this.endNode = endNode;
		this.endEvent = endEvent;
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
