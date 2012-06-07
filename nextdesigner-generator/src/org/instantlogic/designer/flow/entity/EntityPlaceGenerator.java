package org.instantlogic.designer.flow.entity;

import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.TemplatedTextDesign;

public class EntityPlaceGenerator extends PlaceTemplateDesign {

	public static final EntityPlaceGenerator PLACE = new EntityPlaceGenerator();

	private EntityPlaceGenerator() {
		setName("Entity");
	}
	
	@Override
	public void init() {
		setContent(createPageWidget("Entity",
				createText("Paragraph",
					new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(DesignEntityGenerator.name))))
				)
			);
	}

	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign("Page");
		pageWidget.setChildren("headerContent", createText("Heading1", new ConstantTextDesign().setUntranslated(title)));
		pageWidget.setChildren("mainContent", mainContentChildren);
		return pageWidget;
	}
}
