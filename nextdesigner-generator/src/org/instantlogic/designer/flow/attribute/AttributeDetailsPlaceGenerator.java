package org.instantlogic.designer.flow.attribute;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.sharedfragment.EntityContextSharedElement;

public class AttributeDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final AttributeDetailsPlaceGenerator PLACE = new AttributeDetailsPlaceGenerator();

	private AttributeDetailsPlaceGenerator() {
		setName("AttributeDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign attributeName;
		FragmentTemplateDesign nameInput, hasRelevanceInput, hasRuleInput, writeableInput, hasDefaultInput;
		SharedElementDesign entityContext;

		setTitle(new TextTemplateDesign()
			.addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText(" (Attribute)"))
		);
		
		attributeName.deduceAttribute(DesignEntityGenerator.name);
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 

				entityContext = new SharedElementDesign(),
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading1", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" (Attribute)"))
						),
					
						nameInput = new FragmentTemplateDesign("Input"),
						
						hasRelevanceInput = new FragmentTemplateDesign("Input"),
						hasRuleInput = new FragmentTemplateDesign("Input"),
						writeableInput = new FragmentTemplateDesign("Input"),
						hasDefaultInput = new FragmentTemplateDesign("Input")
					)
			)
		);
		
		entityContext.setDefinition(EntityContextSharedElement.DEFINITION);
		attributeName.deduceAttribute(DesignEntityGenerator.name);
		
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
		hasRelevanceInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasRelevance);
		hasRuleInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasRule);
		writeableInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.writeable);
		hasDefaultInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasDefault);
	}
}
