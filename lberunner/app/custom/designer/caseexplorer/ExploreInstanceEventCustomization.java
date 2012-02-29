package custom.designer.caseexplorer;


import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

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
