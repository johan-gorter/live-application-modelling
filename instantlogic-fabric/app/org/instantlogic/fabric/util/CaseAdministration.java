package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class CaseAdministration {

	private HashMap<String, Instance> instances = new HashMap<String, Instance>();
	
	private long version;
	private List<Observations> observationsStack = new ArrayList<Observations>();
	private Observations currentObservations = null;
	
	private SortedMap<String, Entity<?>> allEntities;
	
	private static void addEntities(Entity<?> entity, SortedMap<String, Entity<?>> all) {
		if (all.containsKey(entity.getName())) {
			return;
		}
		all.put(entity.getName(), entity);
		for (Relation<?, ?, ? extends Instance> relation : entity.getRelations()) {
			addEntities(relation.getTo(), all);
		}
	}
	
	public SortedMap<String, Entity<?>> getAllEntities() {
		if (allEntities==null) {
			TreeMap<String, Entity<?>> tempResult = new TreeMap<String, Entity<?>>();
			addEntities(instances.get("0").getMetadata().getEntity(), tempResult);
			allEntities = tempResult;
		}
		return allEntities;
	}
	
	private List<TransactionListener> transactionListeners = new ArrayList<TransactionListener>();
	
	private Operation currentOperation;
	
	public CaseAdministration(Instance rootInstance) {
		instances.put("0", rootInstance);
	}
	
	public Instance getInstanceById(String id) {
		return instances.get(id);
	}

	public void registerObservation(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
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
		currentOperation = operation;
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
		ArrayList<TransactionListener> newListeners = new ArrayList<TransactionListener>(this.transactionListeners);
		newListeners.add(listener);
		this.transactionListeners = newListeners;
	}

	public void removeTransactionListener(TransactionListener listener) {
		ArrayList<TransactionListener> newListeners = new ArrayList<TransactionListener>(this.transactionListeners);
		newListeners.remove(listener);
		this.transactionListeners = newListeners;
	}

	protected void popCurrentOperation(Operation operation) {
		this.currentOperation = operation;
	}
}