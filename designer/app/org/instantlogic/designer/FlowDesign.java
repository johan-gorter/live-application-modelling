package org.instantlogic.designer;

public class FlowDesign extends AbstractFlowDesign {

	public void registerApplication(ApplicationDesign application) {
		application.addToFlows(this);
		for (FlowNodeBaseDesign node : this.getNodes()) {
			if (node instanceof SubFlowDesign) {
				FlowDesign subFlow = ((SubFlowDesign)node).getFlow();
				if (!application.getFlows().contains(subFlow)) {
					subFlow.registerApplication(application);
				}
			}
		}
	}
	
	public void init() {
		for (FlowNodeBaseDesign node : this.getNodes()) {
			if (node instanceof PlaceTemplateDesign) {
				PlaceTemplateDesign place = ((PlaceTemplateDesign)node);
				place.init();
			}
		}
	}
}
