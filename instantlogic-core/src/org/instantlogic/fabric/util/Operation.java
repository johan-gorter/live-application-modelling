package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.List;

public class Operation {
	
	private final InstanceAdministration instanceAdministration;
	private final List<ValueChangeEvent> undoEvents = new ArrayList<ValueChangeEvent>();
	private final Operation partOfOperation;
	private boolean completed;

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
	
	public void clearUndoEvents() {
		this.undoEvents.clear();
	}
	
	public void addUndoEvent(ValueChangeEvent event) {
		this.undoEvents.add(event);
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
				for (ValueChangeEvent event: this.undoEvents) {
					partOfOperation.addUndoEvent(event);
				}
			}
		}
		this.instanceAdministration.popCurrentOperation(partOfOperation);
	}

	protected void undo() {
		throw new RuntimeException("Not yet implemented");
	}
}
