package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;

public class WelcomePlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final WelcomePlaceTemplateGenerator PLACE = new WelcomePlaceTemplateGenerator();
	
	private WelcomePlaceTemplateGenerator() {
		setName("Welcome");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entitiesDeduction, entityName;
		FragmentTemplateDesign link;
		
		setContent(createPageWidget("Welcome", 
			createText("Paragraph", createConstantText("Welcome to the Designer")),
			new FragmentTemplateDesign("Table")
				.setChildren("columns", 
					new FragmentTemplateDesign("Column")
						.setText("header", createConstantText("Entities"))
				)
				.setChildren("rows",
					new FragmentTemplateDesign("Row")
						.setChildren("cells",
							new FragmentTemplateDesign("Cell")
								.setChildren("content",
									new SelectionDesign()
										.setSelection(entitiesDeduction = new DeductionSchemeDesign())
										.addToChildren(
											link = new FragmentTemplateDesign("Link")
												.setText("text", 
													new TextTemplateDesign().addToUntranslated(
														new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign())
													)
											)
										)
								)
						)
				)
		));
		
		entitiesDeduction.deduceRelation(ApplicationDesignEntityGenerator.entities);
		entityName.deduceAttribute(DesignEntityGenerator.name);
		link.setEvent(EntityDetailsEventGenerator.EVENT);
	}
	

	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign("Page");
		pageWidget.setChildren("headerContent", createText("Heading1", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText(title))));
		pageWidget.setChildren("mainContent", mainContentChildren);
		return pageWidget;
	}
}
