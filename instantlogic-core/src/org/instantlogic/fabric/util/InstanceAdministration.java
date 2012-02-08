package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class InstanceAdministration {

	private HashMap<String, Instance<?>> instances = new HashMap<String, Instance<?>>();
	
	private long version;
	private List<Observations> observationsStack = new ArrayList<Observations>();
	private Observations currentObservations = null;
	
	private List<TransactionListener> transactionListeners = new CopyOnWriteArrayList<TransactionListener>();
	
	private Operation currentOperation;
	
	public InstanceAdministration(Instance<? extends Instance<?>> rootInstance) {
		instances.put("0", rootInstance);
	}
	
	public Instance<?> getInstanceById(String id) {
		return instances.get(id);
	}

	public void registerObservation(ReadOnlyAttributeValue<? extends Instance<?>, ? extends Object> attributeValueObserved) {
		if (currentObservations!=null) {
			currentObservations.add(attributeValueObserved);
		}
	}
	
	public void startRecordingObservations() {
		if (currentObservations!=null) {
			observationsStack.add(currentObservations);
		}
		currentObservations = new Observations();
	}

	public Observations stopRecordingObservations() {
		Observations result = currentObservations;
		if (result==null) throw new IllegalStateException();
		if (observationsStack.size()>0) {
			// pop
			currentObservations = observationsStack.get(observationsStack.size()-1);
			observationsStack.remove(observationsStack.size()-1);
		} else {
			currentObservations = null;
		}
		return result;
	}
	
	public void afterLoading() {
	}
	
	public void afterSubmit() {
	}

	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Operation startOperation() {
		Operation operation = new Operation(this, currentOperation);
		operation.start();
		return operation;
	}
	
	protected void fireTransactionStarted()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionStarted(this);
		}
	}
	
	protected void fireTransactionPreparing()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionPreparing(this);
		}
	}
	
	protected void fireTransactionCommitting()	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCommitting(this);
		}
	}
	
	protected void fireTransactionCompleted(boolean committed)	{
		for(TransactionListener listener: transactionListeners) {
			listener.transactionCompleted(this, committed);
		}
	}
	
	public void addTransactionListener(TransactionListener listener) {
		this.transactionListeners.add(listener);
	}

	public void removeTransactionListener(TransactionListener listener) {
		this.transactionListeners.remove(listener);
	}

	protected void popCurrentOperation(Operation operation) {
		this.currentOperation = operation;
	}
}
