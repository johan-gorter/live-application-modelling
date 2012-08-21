package org.instantlogic.engine.presence.flow.traveler;

import static org.instantlogic.designer.util.Deductions.attribute;
import static org.instantlogic.designer.util.Deductions.selectedInstance;
import static org.instantlogic.designer.util.Deductions.toScheme;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
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
				.setChildren("content", new ElementDesign[]{
					new IfElseDesign()
						.setCondition(toScheme(attribute(TravelerEntityGenerator.communicatorVisible, selectedInstance(TravelerEntityGenerator.ENTITY))))
						.addToIfChildren(new FragmentTemplateDesign("Communicator"))
						.addToElseChildren(new FragmentTemplateDesign("ShowCommunicatorButton"))
				})
		);
	}
}
