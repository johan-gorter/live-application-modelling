package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.value.AttributeValue;

public class Operation {
	
	private final InstanceAdministration instanceAdministration;
	private final List<ValueChangeEvent> eventsToUndo = new ArrayList<ValueChangeEvent>();
	private final Operation partOfOperation;
	private boolean completed;
	private int recordingUndoEventsPaused;

	public Operation(InstanceAdministration instanceAdministration, Operation partOfOperation) {
		this.instanceAdministration = instanceAdministration;
		this.partOfOperation = partOfOperation;
	}
	
	public void start() {
		this.instanceAdministration.fireTransactionStarted();
	}

	public void complete() {
		completed = true;
	}
	
	public boolean completed() {
		return completed;
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
		if (!completed) {
			undo();
		} else {
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
		}
		this.instanceAdministration.popCurrentOperation(partOfOperation);
	}

	protected void undo() {
		for (int i=eventsToUndo.size()-1;i>=0;i--) {
			ValueChangeEvent event = eventsToUndo.get(i);
			if (event.isMultivalueUpdate()) {
				throw new RuntimeException("TODO");
			} else {
				AttributeValue attributeValue = (AttributeValue)((Attribute)event.getAttribute()).get(event.getInstance());
				attributeValue.setValue(event.getOldStoredValue());
			}
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
