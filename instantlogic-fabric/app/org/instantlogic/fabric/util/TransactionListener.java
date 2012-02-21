package org.instantlogic.fabric.util;

public interface TransactionListener {

	void transactionStarted(InstanceAdministration instanceAdministration);

	void transactionPreparing(InstanceAdministration instanceAdministration);

	void transactionCommitting(InstanceAdministration instanceAdministration);

	void transactionCompleted(InstanceAdministration instanceAdministration, boolean committed);
	
}
