package org.instantlogic.interaction.flow.impl;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;

import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.FlowEvent;

public class SimpleFlowEvent extends FlowEvent {

	private String name;
	
	private Entity[] parameterTypes;

	public SimpleFlowEvent(String name, Entity... parameterTypes) {
		this.name = name;
		this.parameterTypes = parameterTypes;
	}
	
	@Override
	public Entity[] getParameterTypes() {
		return parameterTypes;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FlowEventOccurrence createOccurrence(ChangeContext context) {
		Instance[] parameters = new Instance[parameterTypes.length];
		for (int i=0;i<parameters.length;i++) {
			parameters[i]=context.getSelectedInstance(parameterTypes[i]);
		}
		return new FlowEventOccurrence(this, parameters);
	}
	
}
