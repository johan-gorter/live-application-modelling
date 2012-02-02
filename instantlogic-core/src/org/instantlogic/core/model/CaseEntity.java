package org.instantlogic.core.model;

import java.util.SortedMap;

import org.instantlogic.core.CaseInstance;

public abstract class CaseEntity<I extends CaseInstance<I>> extends Entity<I> {

	public abstract SortedMap<String, Entity<?>> getEntities();

}
