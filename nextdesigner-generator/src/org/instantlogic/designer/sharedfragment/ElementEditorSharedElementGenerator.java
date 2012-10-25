package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PropertyDesignEntityGenerator;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.CloseEditorEventGenerator;
import org.instantlogic.designer.event.OpenEditorEventGenerator;

public class ElementEditorSharedElementGenerator extends SharedElementDefinitionDesign {

	public static final ElementEditorSharedElementGenerator DEFINITION = new ElementEditorSharedElementGenerator();
	
	private ElementEditorSharedElementGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("ElementEditor");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign fragmentType, propertyName, editorOpen;
		SelectionDesign asFragmentTemplate, selectProperties, selectPropertyChildren;
		FragmentTemplateDesign fragmentTypeNameInput;
		FragmentTemplateDesign openEditorButton, closeEditorButton;
		SharedElementDesign recursiveElementEditor;
		
		setFragment(
			new FragmentTemplateDesign("Block").addToStyleNames("element")
				.setChildren("content",
					asFragmentTemplate = new SelectionDesign()
						.addToChildren(
							new IfElseDesign()
								.setCondition(editorOpen = new DeductionSchemeDesign())
								.addToIfChildren(
									new FragmentTemplateDesign("Block").addToStyleNames("editor")
										.setChildren("content", 
											fragmentTypeNameInput = new FragmentTemplateDesign("Input"),
											closeEditorButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Close editor")))
										)
								.addToElseChildren(openEditorButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Open editor")))
						)
						.addToChildren(new FragmentTemplateDesign("Block").addToStyleNames("info")
							.setChildren("content", 
								new FragmentTemplateDesign("Paragraph").setText("text", new TextTemplateDesign()
									.addToUntranslated(new StringTemplateDesign().setDeduction(fragmentType = new DeductionSchemeDesign())))
							)
						)
						.addToChildren(new FragmentTemplateDesign("Block").addToStyleNames("preview")
							.setChildren("content",
								new FragmentTemplateDesign("Block").addToFragmentFilters("org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter"))
							)
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
		editorOpen.deduceAttribute(ElementDesignEntityGenerator.editorOpen);
		fragmentTypeNameInput.setEntity(FragmentTemplateDesignEntityGenerator.ENTITY).setAttribute(FragmentTemplateDesignEntityGenerator.fragmentTypeName);
		closeEditorButton.setEvent(CloseEditorEventGenerator.EVENT);
		openEditorButton.setEvent(OpenEditorEventGenerator.EVENT);
		
		fragmentType.deduceAttribute(FragmentTemplateDesignEntityGenerator.fragmentTypeName);
		selectProperties.newSelection().deduceAttribute(FragmentTemplateDesignEntityGenerator.properties);
		propertyName.deduceAttribute(PropertyDesignEntityGenerator.propertyName);
		selectPropertyChildren.newSelection().deduceRelation(PropertyDesignEntityGenerator.children);
		
		recursiveElementEditor.setDefinition(DEFINITION);
	}
}
