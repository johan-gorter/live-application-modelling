package lbe.engine;

import org.instantlogic.interaction.flow.FlowNodeBase;

public class UnhandledOccurrenceException extends RuntimeException {

	public UnhandledOccurrenceException(FlowNodeBase lastNode, FlowEventOccurrence lastOccurrence) {
		super("Event occurrence "+lastOccurrence.getEvent().getName()+" was not handled at node "+lastNode.getName()+" or below");
	}
}
