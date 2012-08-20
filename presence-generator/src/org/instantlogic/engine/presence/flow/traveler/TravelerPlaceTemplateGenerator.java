package org.instantlogic.engine.presence.flow.traveler;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.util.Deductions;
import org.instantlogic.engine.presence.PresenceEntityGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.UserEntityGenerator;

public class TravelerPlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final TravelerPlaceTemplateGenerator PLACE = new TravelerPlaceTemplateGenerator();
	
	private TravelerPlaceTemplateGenerator() {
		setName("Presence");
	}
	
	@Override
	public void init() {
		setContent(
			new FragmentTemplateDesign("Presence")
				.setValue("applicationName", createDeduction(PresenceEntityGenerator.applicationName))
				.setValue("caseName", createDeduction(PresenceEntityGenerator.caseName))
				.setValue("userName", Deductions.toScheme(Deductions.reverseRelation(UserEntityGenerator.travelers, Deductions.selectedInstance(TravelerEntityGenerator.ENTITY))))
		);
	}
}
