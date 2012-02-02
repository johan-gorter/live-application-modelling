package org.instantlogic.interaction.flow;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;

import org.instantlogic.core.model.Concept;
import org.instantlogic.core.model.Entity;

public abstract class FlowEvent extends Concept {

	public abstract Entity[] getParameterTypes();
	
	public abstract FlowEventOccurrence createOccurrence(ChangeContext context);
	
}
