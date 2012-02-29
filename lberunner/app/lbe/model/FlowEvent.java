package lbe.model;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;

public abstract class FlowEvent extends Model {

	public abstract Entity[] getParameterTypes();
	
	public abstract FlowEventOccurrence createOccurrence(ChangeContext context);
	
}
