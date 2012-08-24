package org.instantlogic.engine.presence.flow.traveler;

import static org.instantlogic.designer.util.Deductions.*;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.engine.presence.PlaceEntityGenerator;
import org.instantlogic.engine.presence.PresenceEntityGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.UserEntityGenerator;

public class TravelerPlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final TravelerPlaceTemplateGenerator PLACE = new TravelerPlaceTemplateGenerator();
	
	private TravelerPlaceTemplateGenerator() {
		setName("Traveler");
	}
	
	@Override
	public void init() {
		setContent(
			new FragmentTemplateDesign("Presence")
				.setValue("applicationName", createDeduction(PresenceEntityGenerator.applicationName))
				.setValue("caseName", createDeduction(PresenceEntityGenerator.caseName))
				.setChildren("content", new ElementDesign[]{
					new IfElseDesign()
						.setCondition(toScheme(hasValue(relation(TravelerEntityGenerator.user, selectedInstance(TravelerEntityGenerator.ENTITY)))))
						.addToIfChildren(
							new FragmentTemplateDesign("Me")
								.setValue("username", toScheme(attribute(UserEntityGenerator.username, relation(TravelerEntityGenerator.user, selectedInstance(TravelerEntityGenerator.ENTITY)))))
						)
						.addToIfChildren(
							new IfElseDesign()
								.setCondition(toScheme(attribute(TravelerEntityGenerator.communicatorVisible, selectedInstance(TravelerEntityGenerator.ENTITY))))
								.addToIfChildren(
									new FragmentTemplateDesign("Communicator")
										.setChildren("users", 
											new SelectionDesign()
												.setSelection(toScheme(relation(PresenceEntityGenerator.activeUsers, selectedInstance(PresenceEntityGenerator.ENTITY))))
												.addToChildren(new FragmentTemplateDesign("User")
													.setValue("username", toScheme(attribute(UserEntityGenerator.username, selectedInstance(UserEntityGenerator.ENTITY))))
												)
												.addToChildren(new SelectionDesign()
													.setSelection(toScheme(reverseRelation(TravelerEntityGenerator.user, selectedInstance(UserEntityGenerator.ENTITY))))
													.addToChildren(new FragmentTemplateDesign("Traveler")
														.setValue("travelerId", toScheme(attribute(TravelerEntityGenerator.id)))
														.setValue("placeUrl", toScheme(attribute(PlaceEntityGenerator.url, relation(TravelerEntityGenerator.currentPlace))))
													)
												)
										)
								)
								.addToElseChildren(new FragmentTemplateDesign("ShowCommunicatorButton"))								
						)
						.addToElseChildren(new FragmentTemplateDesign("Login"))
					
				})
		);
	}
}
