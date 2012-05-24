package org.instantlogic.designer.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.flow.main.WelcomePlaceGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	public void registerApplication(ApplicationDesign application) {
		if (application.getFlows().contains(this)) return;
		application.addToFlows(this);
		for (FlowNodeBaseDesign node : this.getNodes()) {
			if (node instanceof SubFlowDesign) {
				FlowDesign subFlow = ((SubFlowDesign)node).getFlow();
				//TODO: subFlow.registerApplication(application);
			}
		}
	}

	public void init() {
		FlowSourceDesign source = new FlowSourceDesign();
		addToSources(source);
		
		addToNodes(WelcomePlaceGenerator.PLACE);
	}

}
