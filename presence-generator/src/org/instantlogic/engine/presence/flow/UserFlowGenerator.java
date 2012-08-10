package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.UserEntityGenerator;
import org.instantlogic.engine.presence.flow.user.PresencePlaceTemplateGenerator;

public class UserFlowGenerator extends FlowDesign {
	
	public static final UserFlowGenerator FLOW = new UserFlowGenerator();

	private UserFlowGenerator() {
		setName("User");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		addToParameters(UserEntityGenerator.ENTITY);
		
		addToNodes(PresencePlaceTemplateGenerator.PLACE);
		
		super.registerApplication(application);
	}
}
