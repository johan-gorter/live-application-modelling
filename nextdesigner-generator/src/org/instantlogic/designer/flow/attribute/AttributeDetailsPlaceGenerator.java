package org.instantlogic.designer.flow.attribute;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;

public class AttributeDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final AttributeDetailsPlaceGenerator PLACE = new AttributeDetailsPlaceGenerator();

	private AttributeDetailsPlaceGenerator() {
		setName("AttributeDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign attributeName;
		FragmentTemplateDesign nameInput;
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				createText("Heading1", new TextTemplateDesign()
					.addToUntranslated(new StringTemplateDesign().setConstantText("Attribute "))
					.addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign()))
				),
				
				nameInput = new FragmentTemplateDesign("Input")
				
			)
		);
		
		attributeName.deduceAttribute(DesignEntityGenerator.name);
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
	}
}
