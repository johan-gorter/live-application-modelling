package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.event.FlowDetailsEventGenerator;

public class WelcomePlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final WelcomePlaceTemplateGenerator PLACE = new WelcomePlaceTemplateGenerator();
	
	private WelcomePlaceTemplateGenerator() {
		setName("Welcome");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entitiesDeduction, flowsDeduction, entityName, flowName;
		FragmentTemplateDesign entityLink, flowLink;
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				createText("Heading1", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Welcome"))),
					
				createText("Paragraph", createConstantText("Welcome to the Designer")),
				
				new FragmentTemplateDesign("Table")
					.setChildren("columns", 
						new FragmentTemplateDesign("Column")
							.setText("header", createConstantText("Entities"))
					)
					.setChildren("rows",
						new SelectionDesign()
							.setSelection(entitiesDeduction = new DeductionSchemeDesign())
							.addToChildren(
								new FragmentTemplateDesign("Row")
									.setChildren("cells",
										new FragmentTemplateDesign("Cell")
											.setChildren("content",
												entityLink = new FragmentTemplateDesign("Link")
													.setText("text", 
														new TextTemplateDesign().addToUntranslated(
															new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign())
														)
												)
											)
									)
							)
					),
					
					new FragmentTemplateDesign("Table")
						.setChildren("columns", 
							new FragmentTemplateDesign("Column")
								.setText("header", createConstantText("Flows"))
						)
						.setChildren("rows",
							new SelectionDesign()
								.setSelection(flowsDeduction = new DeductionSchemeDesign())
								.addToChildren(
									new FragmentTemplateDesign("Row")
										.setChildren("cells",
											new FragmentTemplateDesign("Cell")
												.setChildren("content",
													flowLink = new FragmentTemplateDesign("Link")
														.setText("text", 
															new TextTemplateDesign().addToUntranslated(
																new StringTemplateDesign().setDeduction(flowName = new DeductionSchemeDesign())
															)
													)
												)
										)
								)
						)
		));
		
		entitiesDeduction.deduceRelation(ApplicationDesignEntityGenerator.entities);
		flowsDeduction.deduceRelation(ApplicationDesignEntityGenerator.flows);
		entityName.deduceAttribute(DesignEntityGenerator.name);
		flowName.deduceAttribute(DesignEntityGenerator.name, flowName.deduceSelectedInstance(FlowDesignEntityGenerator.ENTITY));
		entityLink.setEvent(EntityDetailsEventGenerator.EVENT);
		flowLink.setEvent(FlowDetailsEventGenerator.EVENT);
	}
}
