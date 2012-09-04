package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	@Override
	public void init() {
		SubFlowDesign travelerSubFlow = new SubFlowDesign().setFlow(TravelerFlowGenerator.FLOW);
		travelerSubFlow.setName("Traveler");
		addToNodes(travelerSubFlow);
		super.init();
	}
}
