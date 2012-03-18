package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;

public class Operation {
	
	public enum OperationState {STARTED, UNDOING, COMPLETED, CLOSED}
	private final CaseAdministration instanceAdministration;
	private final List<ValueChangeEvent> eventsToUndo = new ArrayList<ValueChangeEvent>();
	private final Operation partOfOperation;
	private OperationState state;
	private int recordingUndoEventsPaused;

	public Operation(CaseAdministration instanceAdministration, Operation partOfOperation) {
		this.instanceAdministration = instanceAdministration;
		this.partOfOperation = partOfOperation;
	}
	
	public void start() {
		state = OperationState.STARTED;
		this.instanceAdministration.fireTransactionStarted();
	}

	public void complete() {
		if (state!=OperationState.STARTED) throw new IllegalStateException();
		state = OperationState.COMPLETED;
	}
	
	public boolean completed() {
		return state == OperationState.COMPLETED;
	}
	
	/**
	 * Adds an event that must be undone in case the operation does not complete.
	 * 
	 * @param event the event to undo
	 */
	public void addEventToUndo(ValueChangeEvent event) {
		if (recordingUndoEventsPaused==0) {
			this.eventsToUndo.add(event);
		}
	}
	
	public void close() {
		if (state==OperationState.STARTED) { // We were not completed, we should undo (called from a finally block)
			if (partOfOperation!=null && partOfOperation.state == OperationState.UNDOING) return; // The undo operation on our parent crashed here, we have done enough damage.
			undo();
			state=OperationState.CLOSED;
		} else if (state==OperationState.COMPLETED) {
			if (partOfOperation==null) {
				boolean committed = false;
				try {
					this.instanceAdministration.fireTransactionPreparing();
					this.instanceAdministration.fireTransactionCommitting();
					committed = true;
				} finally {
					this.instanceAdministration.fireTransactionCompleted(committed);
				}
			} else {
				for (ValueChangeEvent event: this.eventsToUndo) {
					partOfOperation.addEventToUndo(event);
				}
			}
		} else {
			throw new IllegalStateException(""+state);
		}
		this.instanceAdministration.popCurrentOperation(partOfOperation);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void undo() {
		state = OperationState.UNDOING;
		pauseRecordingUndoEvents();
		try {
			for (int i=eventsToUndo.size()-1;i>=0;i--) {
				ValueChangeEvent event = eventsToUndo.get(i);
				if (event.isMultivalueUpdate()) {
					AttributeValues attributeValues = (AttributeValues)((Attribute)event.getAttribute()).get(event.getInstance());
					if (event.getMultiValueUpdateType()==MultiValueUpdateType.INSERT) {
						attributeValues.removeValue(event.getIndex());
					}
					if (event.getMultiValueUpdateType()==MultiValueUpdateType.DELETE) {
						attributeValues.insertValue(event.getItemValue(), event.getIndex());
					}
				} else {
					AttributeValue attributeValue = (AttributeValue)((Attribute)event.getAttribute()).get(event.getInstance());
					attributeValue.setValue(event.getOldStoredValue());
				}
			}
		} finally {
			resumeRecordingUndoEvents();
		}
	}

	public void pauseRecordingUndoEvents() {
		this.recordingUndoEventsPaused ++;
	}

	public void resumeRecordingUndoEvents() {
		if (recordingUndoEventsPaused==0) throw new IllegalStateException();
		this.recordingUndoEventsPaused --;
	}
}
