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
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				createText("Heading1", new TextTemplateDesign()
					.addToUntranslated(new StringTemplateDesign().setConstantText("Entity "))
					.addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign()))
				),
				
				createText("Heading2",
					new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Attributes"))))
				);
		
		entityName.deduceAttribute(DesignEntityGenerator.name);
	}
}
