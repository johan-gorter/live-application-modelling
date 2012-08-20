package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.flow.traveler.TravelerPlaceTemplateGenerator;

public class TravelerFlowGenerator extends FlowDesign {
	
	public static final TravelerFlowGenerator FLOW = new TravelerFlowGenerator();

	private TravelerFlowGenerator() {
		setName("Traveler");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		addToParameters(TravelerEntityGenerator.ENTITY);
		
		addToNodes(TravelerPlaceTemplateGenerator.PLACE);
		
		super.registerApplication(application);
	}
}
