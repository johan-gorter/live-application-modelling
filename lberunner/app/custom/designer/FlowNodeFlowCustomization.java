package custom.designer;


import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

import app.designer.PageDesign;
import app.designer.SubFlowDesign;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.PageDetailsEvent;
import app.designer.flow.FlowNodeFlow;

public class FlowNodeFlowCustomization extends FlowNodeFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance parameter = occurrence.getParameters()[0];
		if (parameter instanceof PageDesign) {
			return new FlowEventOccurrence(PageDetailsEvent.INSTANCE, parameter);
		} else if (parameter instanceof SubFlowDesign) {
			return new FlowEventOccurrence(FlowDetailsEvent.INSTANCE, ((SubFlowDesign)parameter).flow.get());
		}
		throw new RuntimeException("Unknown parameter type: "+parameter.getModel().getName());
	}
}
