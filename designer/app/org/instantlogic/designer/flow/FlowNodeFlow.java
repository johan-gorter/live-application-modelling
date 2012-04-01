package org.instantlogic.designer.flow;

import org.instantlogic.designer.PageDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.FlowDetailsEvent;
import org.instantlogic.designer.event.PageDetailsEvent;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class FlowNodeFlow extends AbstractFlowNodeFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance parameter = occurrence.getParameters()[0];
		if (parameter instanceof PageDesign) {
			return new FlowEventOccurrence(PageDetailsEvent.INSTANCE, parameter);
		} else if (parameter instanceof SubFlowDesign) {
			return new FlowEventOccurrence(FlowDetailsEvent.INSTANCE, ((SubFlowDesign)parameter).getFlow());
		}
		throw new RuntimeException("Unknown parameter type: "+parameter.getMetadata().getEntity().getName());
	}
	
}
