package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setApplication(PresenceApplicationGenerator.APPLICATION);
		setName("Main");
	}
	
	@Override
	public void init() {
		SubFlowDesign travelerSubFlow = new SubFlowDesign();
		addToNodes(travelerSubFlow);
		travelerSubFlow.setFlow(TravelerFlowGenerator.FLOW);
		travelerSubFlow.setName("Traveler");
		super.init();
	}
}
