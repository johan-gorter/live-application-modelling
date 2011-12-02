package lbe.engine;

import lbe.model.flow.FlowNodeBase;

public class UnhandledOccurrenceException extends RuntimeException {

	public UnhandledOccurrenceException(FlowNodeBase lastNode, FlowEventOccurrence lastOccurrence) {
		super("Event occurrence "+lastOccurrence.getEvent().getName()+" was not handled at node "+lastNode.getName()+" or below");
	}
}
