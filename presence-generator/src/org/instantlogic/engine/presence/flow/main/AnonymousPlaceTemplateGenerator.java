package org.instantlogic.engine.presence.flow.main;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.engine.presence.PresenceEntityGenerator;

public class AnonymousPlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final AnonymousPlaceTemplateGenerator PLACE = new AnonymousPlaceTemplateGenerator();
	
	private AnonymousPlaceTemplateGenerator() {
		setName("Anonymous");
	}
	
	@Override
	public void init() {
		setContent(
			new FragmentTemplateDesign("Presence")
				.setValue("applicationName", createDeduction(PresenceEntityGenerator.applicationName))
				.setValue("caseName", createDeduction(PresenceEntityGenerator.caseName))
				.setChildren("content", new FragmentTemplateDesign("Login"))
		);
	}
}
