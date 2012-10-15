package org.instantlogic.designer.flow.attribute;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DataTypeDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
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
		FragmentTemplateDesign nameInput, categoryInput, multilineInput, formattedInput, hasRelevanceInput, hasRuleInput, writeableInput, hasDefaultInput;
		SharedElementDesign entityContext;
		SelectionDesign selectDataType;

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
						
						new FragmentTemplateDesign("Heading2").setText("text", createConstantText("Data type")),
						selectDataType = new SelectionDesign()
							.addToChildren(categoryInput = new FragmentTemplateDesign("Input"))
							.addToChildren(multilineInput = new FragmentTemplateDesign("Input"))
							.addToChildren(formattedInput = new FragmentTemplateDesign("Input")),
						new FragmentTemplateDesign("Heading2").setText("text", createConstantText("Value")),
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
		
		selectDataType.setSelection(new DeductionSchemeDesign());
		selectDataType.getSelection().deduceAttribute(AttributeDesignEntityGenerator.dataType).getScheme();
		
		categoryInput.setEntity(DataTypeDesignEntityGenerator.ENTITY).setAttribute(DataTypeDesignEntityGenerator.dataCategory);
		
		multilineInput.setEntity(DataTypeDesignEntityGenerator.ENTITY).setAttribute(DataTypeDesignEntityGenerator.multiLine);
		formattedInput.setEntity(DataTypeDesignEntityGenerator.ENTITY).setAttribute(DataTypeDesignEntityGenerator.formatted);
		
		hasRelevanceInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasRelevance);
		hasRuleInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasRule);
		writeableInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.writeable);
		hasDefaultInput.setEntity(AttributeDesignEntityGenerator.ENTITY).setAttribute(AttributeDesignEntityGenerator.hasDefault);
	}
}
