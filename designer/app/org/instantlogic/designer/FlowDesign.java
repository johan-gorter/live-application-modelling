package org.instantlogic.designer;

public class FlowDesign extends AbstractFlowDesign {

	public FlowDesign(){}
	
	public FlowDesign(String name) {
		setName(name);
	}
	
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

	public SubFlowDesign addSubFlow(FlowDesign flow) {
		SubFlowDesign result = new SubFlowDesign();
		addToNodes(result);
		result.setFlow(flow);
		result.setName(flow.getName());
		return result;
	}
}