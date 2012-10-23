package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;
import org.instantlogic.designer.PropertyDesignEntityGenerator;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;

public class ElementEditorSharedElement extends SharedElementDefinitionDesign {

	public static final ElementEditorSharedElement DEFINITION = new ElementEditorSharedElement();
	
	private ElementEditorSharedElement() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("ElementEditor");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign fragmentType, propertyName;
		SelectionDesign asFragmentTemplate, selectProperties, selectPropertyChildren;
		SharedElementDesign recursiveElementEditor;
		
		setFragment(
			new FragmentTemplateDesign("Block")
				.setChildren("content",
					asFragmentTemplate = new SelectionDesign()
						.addToChildren(
							new FragmentTemplateDesign("Paragraph").setText("text", new TextTemplateDesign()
								.addToUntranslated(new StringTemplateDesign().setDeduction(fragmentType = new DeductionSchemeDesign()))))
						.addToChildren(
							selectProperties = new SelectionDesign()
								.addToChildren(
									new FragmentTemplateDesign("Paragraph").setText("text", new TextTemplateDesign()
										.addToUntranslated(new StringTemplateDesign().setDeduction(propertyName = new DeductionSchemeDesign()))
									)
								)
								.addToChildren(
									selectPropertyChildren = new SelectionDesign()
										.addToChildren(recursiveElementEditor = new SharedElementDesign())
								)
						)
				)
		);
		
		asFragmentTemplate.newSelection()
			.deduceCastInstance(asFragmentTemplate.getSelection()
				.deduceSelectedInstance(ElementDesignEntityGenerator.ENTITY), FragmentTemplateDesignEntityGenerator.ENTITY);
		fragmentType.deduceAttribute(FragmentTemplateDesignEntityGenerator.fragmentTypeName);
		selectProperties.newSelection().deduceAttribute(FragmentTemplateDesignEntityGenerator.properties);
		propertyName.deduceAttribute(PropertyDesignEntityGenerator.propertyName);
		selectPropertyChildren.newSelection().deduceRelation(PropertyDesignEntityGenerator.children);
		
		recursiveElementEditor.setDefinition(DEFINITION);
	}
}
