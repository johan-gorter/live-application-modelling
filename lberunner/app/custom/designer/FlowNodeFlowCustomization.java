package custom.designer;

import lbe.engine.FlowContext;
import lbe.engine.FlowEventOccurrence;
import lbe.instance.Instance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.SubFlowInstance;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.PageDetailsEvent;
import app.designer.flow.FlowNodeFlow;

public class FlowNodeFlowCustomization extends FlowNodeFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance parameter = occurrence.getParameters()[0];
		if (parameter instanceof PageInstance) {
			return new FlowEventOccurrence(PageDetailsEvent.INSTANCE, parameter);
		} else if (parameter instanceof SubFlowInstance) {
			return new FlowEventOccurrence(FlowDetailsEvent.INSTANCE, ((SubFlowInstance)parameter).flow.get());
		}
		throw new RuntimeException("Unknown parameter type: "+parameter.getModel().getName());
	}
}
