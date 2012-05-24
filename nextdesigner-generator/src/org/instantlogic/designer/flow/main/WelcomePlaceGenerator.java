package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.FragmentChildList;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentText;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.TextDesign;

public class WelcomePlaceGenerator extends PlaceTemplateDesign {

	public static final WelcomePlaceGenerator PLACE = new WelcomePlaceGenerator();
	
	private WelcomePlaceGenerator() {
		setName("Welcome");
		
		setContent(createPageWidget("Welcome", 
			createText("Paragraph", createConstantText("Welcome to the Designer"))
		));
	}
	
	protected static ConstantTextDesign createConstantText(String untranslated) {
		ConstantTextDesign result = new ConstantTextDesign();
		result.setUntranslated(untranslated);
		return result;
	}
	
	protected static FragmentTemplateDesign createText(String fragmentTypeName, TextDesign text) {
		FragmentTemplateDesign result = new FragmentTemplateDesign();
		result.setFragmentTypeName(fragmentTypeName);
		FragmentText widgetText = new FragmentText();
		widgetText.setName("text");
		widgetText.setText(text);
		result.addToTexts(widgetText);
		return result;
	}

	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign().setFragmentTypeName("Page");
		FragmentChildList mainContent = new FragmentChildList();
		mainContent.setName("mainContent");
		for (FragmentTemplateDesign child : mainContentChildren) {
			mainContent.addToChildren(child);
		}
		FragmentChildList headerContent = new FragmentChildList();
		headerContent.setName("headerContent");
		FragmentText headerText = new FragmentText().setText(new ConstantTextDesign().setUntranslated(title));
		headerText.setName("text");
		headerContent.addToChildren(new FragmentTemplateDesign().setFragmentTypeName("Heading1").addToTexts(headerText));
		pageWidget.addToChildLists(headerContent);
		pageWidget.addToChildLists(mainContent);
		return pageWidget;
	}
	
	
}
