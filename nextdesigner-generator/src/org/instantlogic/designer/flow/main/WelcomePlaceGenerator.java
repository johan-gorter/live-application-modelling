package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.TemplatedTextDesign;

public class WelcomePlaceGenerator extends PlaceTemplateDesign {

	public static final WelcomePlaceGenerator PLACE = new WelcomePlaceGenerator();
	
	private WelcomePlaceGenerator() {
		setName("Welcome");
		
		setContent(createPageWidget("Welcome", 
			createText("Paragraph", createConstantText("Welcome to the Designer")),
			createMainTable()
		));
	}
	

	private FragmentTemplateDesign createMainTable() {
		FragmentTemplateDesign table = new FragmentTemplateDesign("Table");
		FragmentTemplateDesign entitiesColumn = new FragmentTemplateDesign("Column");
		entitiesColumn.setText("header", createConstantText("Entities"));
		table.setChildren("columns", entitiesColumn);
		FragmentTemplateDesign onlyRow = new FragmentTemplateDesign("Row");
		FragmentTemplateDesign entitiesCell = new FragmentTemplateDesign("Cell");
		FragmentTemplateDesign entityLink = createText(
			"Paragraph", 
			new TemplatedTextDesign().addToUntranslated(
				new FormattedValueDesign().setDeduction(createDeduction(DesignEntityGenerator.name))
			)
		);
		entityLink.addToSelections(createDeduction(ApplicationDesignEntityGenerator.entities));
		entitiesCell.setChildren("content", entityLink);
		onlyRow.setChildren("cells", entitiesCell);
		table.setChildren("rows", onlyRow);
		return table;
	}


	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign("Page");
		pageWidget.setChildren("headerContent", createText("Heading1", new ConstantTextDesign().setUntranslated(title)));
		pageWidget.setChildren("mainContent", mainContentChildren);
		return pageWidget;
	}
}
