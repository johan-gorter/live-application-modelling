package org.instantlogic.designer.flow.flow;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FlowNodeBaseDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.deduction.CapitalizeFirstDeduction;
import org.instantlogic.designer.event.FlowNodeDetailsEventGenerator;
import org.instantlogic.designer.sharedfragment.ApplicationContextSharedElementGenerator;

public class FlowDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final FlowDetailsPlaceGenerator PLACE = new FlowDetailsPlaceGenerator();

	private FlowDetailsPlaceGenerator() {
		setName("FlowDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign flowName, nodes, nodeName;
		FragmentTemplateDesign nameInput, nodeLink;
		SharedElementDesign applicationContext;
		
		setTitle(new TextTemplateDesign()
					.addToUntranslated(new StringTemplateDesign().setDeduction(flowName = new DeductionSchemeDesign()))
					.addToUntranslated(new StringTemplateDesign().setConstantText(" (Flow)"))
		);
		
		flowName.deduceCustom(CapitalizeFirstDeduction.class, String.class, flowName.deduceAttribute(DesignEntityGenerator.name));
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				applicationContext = new SharedElementDesign(),	
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading3", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setDeduction(flowName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" (Flow)"))
						),
						
						nameInput = new FragmentTemplateDesign("Input"),
						
						createText("Heading4",
							new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Nodes"))
						),
						
						new SelectionDesign()
							.setSelection(nodes = new DeductionSchemeDesign())
							.addToChildren(
								nodeLink = new FragmentTemplateDesign("Link")
									.setChildren("content", 
										new FragmentTemplateDesign("Block")
											.setChildren("content",
												new FragmentTemplateDesign("Strong")
													.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(nodeName = new DeductionSchemeDesign())))
											)
									)
							)
					)
			)
		);
		
		applicationContext.setDefinition(ApplicationContextSharedElementGenerator.DEFINITION);
		
		flowName.deduceCustom(CapitalizeFirstDeduction.class, String.class, flowName.deduceAttribute(DesignEntityGenerator.name));
		nodes.deduceAttribute(FlowDesignEntityGenerator.nodes);
		nodeName.deduceAttribute(DesignEntityGenerator.name, nodeName.deduceSelectedInstance(FlowNodeBaseDesignEntityGenerator.ENTITY));
		nodeLink.setEvent(FlowNodeDetailsEventGenerator.EVENT);
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
	}
}
