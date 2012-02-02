package org.instantlogic.core;

import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.util.InstanceRegistry;


public interface CaseInstance<I extends CaseInstance<I>> extends Instance<I> {

	InstanceRegistry getRegistry();
	
	@Override
	CaseEntity<I> getModel();
	
}
