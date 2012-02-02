package org.instantlogic.core;

import java.io.Serializable;

import org.instantlogic.core.model.Entity;
import org.instantlogic.core.util.ValueChangeListener;




/**
 * Can be compared to a class, only more powerful.
 * 
 * Note that an instance should always have an owner. the root of this owner hierarchy extends CaseInstance.
 */
public interface Instance<I extends Instance<I>> extends Serializable {
	
	CaseInstance<?> getCase();
	
	long getInstanceId();
	
	// TODO --> getEntity
	Entity<I> getModel();
	
	public void addGlobalValueChangeListener(ValueChangeListener listener, boolean forOwnedInstancesAsWell);

	public void removeGlobalValueChangeListener(ValueChangeListener listener);
	
}
