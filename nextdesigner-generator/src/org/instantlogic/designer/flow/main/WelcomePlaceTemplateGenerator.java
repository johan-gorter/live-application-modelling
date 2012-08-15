package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
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
		SelectionDesign selectEntity = new SelectionDesign().setSelection(createDeduction(ApplicationDesignEntityGenerator.entities));
		FragmentTemplateDesign entityLink = createLink(
			new TextTemplateDesign().addToUntranslated(
				new StringTemplateDesign().setDeduction(createDeduction(DesignEntityGenerator.name))
			),
			EntityDetailsEventGenerator.EVENT
		);
		selectEntity.addToChildren(entityLink);
		entitiesCell.setChildren("content", selectEntity);
		onlyRow.setChildren("cells", entitiesCell);
		table.setChildren("rows", onlyRow);
		return table;
	}


	private static FragmentTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		FragmentTemplateDesign pageWidget = new FragmentTemplateDesign("Page");
		pageWidget.setChildren("headerContent", createText("Heading1", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText(title))));
		pageWidget.setChildren("mainContent", mainContentChildren);
		return pageWidget;
	}
}
