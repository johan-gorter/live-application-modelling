package custom.designer.caseexplorer;

import lbe.engine.ChangeContext;
import lbe.engine.FlowEventOccurrence;

import org.instantlogic.fabric.Instance;

import app.designer.event.ExploreInstanceEvent;

/**
 * Gets the last selected instance from the context and stores this as the only parameter. 
 */
public class ExploreInstanceEventCustomization extends ExploreInstanceEvent {

	@Override
	public FlowEventOccurrence createOccurrence(ChangeContext context) {
		Instance[] parameters = new Instance[1];
		parameters[0]=context.getSelectedInstance(null);
		return new FlowEventOccurrence(this, parameters);
	}
}
