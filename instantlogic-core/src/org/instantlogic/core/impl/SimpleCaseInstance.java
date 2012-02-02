package org.instantlogic.core.impl;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.util.InstanceRegistry;

public abstract class SimpleCaseInstance<I extends SimpleCaseInstance<I>> extends SimpleInstance<I> implements CaseInstance<I> {
	
	private InstanceRegistry registry = new InstanceRegistry(this);
	
	@Override
	public InstanceRegistry getRegistry() {
		return registry;
	}
	
	public SimpleCaseInstance() {
		super(null, 0);
	}
	
	@Override
	public CaseInstance<I> getCase() {
		return this;
	}
	
	@Override
	public abstract CaseEntity<I> getModel();
}
