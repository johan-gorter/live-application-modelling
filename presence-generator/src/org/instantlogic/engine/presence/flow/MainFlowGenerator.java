package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.UserEntityGenerator;
import org.instantlogic.engine.presence.flow.main.PresencePlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		addToParameters(UserEntityGenerator.ENTITY);
		
		addToNodes(PresencePlaceTemplateGenerator.PLACE);
		
		super.registerApplication(application);
	}
}
