package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;

public class TravelerFlowGenerator extends FlowDesign {
	
	public static final TravelerFlowGenerator FLOW = new TravelerFlowGenerator();

	private TravelerFlowGenerator() {
		setApplication(PresenceApplicationGenerator.APPLICATION);
		setName("Traveler");
	}
	
	@Override
	public void init() {
		addToParameters(TravelerEntityGenerator.ENTITY);
		super.init();
	}
}
