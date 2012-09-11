package org.instantlogic.designer.flow.entity;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;

public class EntityDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final EntityDetailsPlaceGenerator PLACE = new EntityDetailsPlaceGenerator();

	private EntityDetailsPlaceGenerator() {
		setName("EntityDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entityName;
		
		setContent(createPageWidget("Entity",
				createText("Paragraph",
					new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign())))
				)
			);
		
		entityName.deduceAttribute(DesignEntityGenerator.name);
	}

	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign("Page");
		pageWidget.setChildren("headerContent", createText("Heading1", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText((title)))));
		pageWidget.setChildren("mainContent", mainContentChildren);
		return pageWidget;
	}
}
