package org.instantlogic.designer.flow.entity;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.deduction.CapitalizeFirstDeduction;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.event.HomeEventGenerator;

public class EntityDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final EntityDetailsPlaceGenerator PLACE = new EntityDetailsPlaceGenerator();

	private EntityDetailsPlaceGenerator() {
		setName("EntityDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entityName, attributes, attributeName, applicationName;
		FragmentTemplateDesign nameInput, attributeLink, applicationLink;
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				applicationLink = new FragmentTemplateDesign("Link")
					.setChildren("content",
						new  FragmentTemplateDesign("Block")
							.addToStyleNames("inactive-card")
							.setChildren("content",
								createText("Heading1", new TextTemplateDesign()
									.addToUntranslated(new StringTemplateDesign().setDeduction(applicationName = new DeductionSchemeDesign()))
									.addToUntranslated(new StringTemplateDesign().setConstantText(" (Application)")))
							)
					),
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading1", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setConstantText("Entity "))
							.addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign()))
						),
						
						nameInput = new FragmentTemplateDesign("Input"),
						
						createText("Heading2",
							new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Attributes"))
						),
						
						new SelectionDesign()
							.setSelection(attributes = new DeductionSchemeDesign())
							.addToChildren(
								attributeLink = new FragmentTemplateDesign("Link")
									.setChildren("content", 
										new FragmentTemplateDesign("Block")
											.setChildren("content",
												new FragmentTemplateDesign("Strong")
													.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign())))
											)
									)
							)
					)
			)
		);
		
		applicationName.deduceAttribute(ApplicationDesignEntityGenerator.name);
		applicationLink.setEvent(HomeEventGenerator.EVENT);
		
		entityName.deduceCustom(CapitalizeFirstDeduction.class, String.class, entityName.deduceAttribute(DesignEntityGenerator.name));
		attributes.deduceAttribute(EntityDesignEntityGenerator.attributes);
		attributeName.deduceAttribute(DesignEntityGenerator.name, attributeName.deduceSelectedInstance(AttributeDesignEntityGenerator.ENTITY));
		attributeLink.setEvent(AttributeDetailsEventGenerator.EVENT);
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
	}
}
