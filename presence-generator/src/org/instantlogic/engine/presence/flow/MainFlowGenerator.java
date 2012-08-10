package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.engine.presence.flow.main.AnonymousPlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		addToNodes(AnonymousPlaceTemplateGenerator.PLACE);
		SubFlowDesign userSubFlow = new SubFlowDesign().setFlow(UserFlowGenerator.FLOW);
		userSubFlow.setName("User");
		addToNodes(userSubFlow);
		
		super.registerApplication(application);
	}
}
