package org.instantlogic.engine.presence.flow.user;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.engine.presence.PresenceEntityGenerator;
import org.instantlogic.engine.presence.UserEntityGenerator;

public class PresencePlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final PresencePlaceTemplateGenerator PLACE = new PresencePlaceTemplateGenerator();
	
	private PresencePlaceTemplateGenerator() {
		setName("Presence");
	}
	
	@Override
	public void init() {
		setContent(
			new FragmentTemplateDesign("Presence")
				.setValue("applicationName", createDeduction(PresenceEntityGenerator.applicationName))
				.setValue("caseName", createDeduction(PresenceEntityGenerator.caseName))
				.setValue("userName", createDeduction(UserEntityGenerator.userName))
		);
	}
}
