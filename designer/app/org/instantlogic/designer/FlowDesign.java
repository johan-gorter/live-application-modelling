package org.instantlogic.designer;

public class FlowDesign extends AbstractFlowDesign {

	public void registerApplication(ApplicationDesign application) {
		if (application.getFlows().contains(this)) return;
		application.addToFlows(this);
		for (FlowNodeBaseDesign node : this.getNodes()) {
			if (node instanceof SubFlowDesign) {
				FlowDesign subFlow = ((SubFlowDesign)node).getFlow();
				subFlow.registerApplication(application);
			}
		}
	}
	
	public void init() {
	}

}
