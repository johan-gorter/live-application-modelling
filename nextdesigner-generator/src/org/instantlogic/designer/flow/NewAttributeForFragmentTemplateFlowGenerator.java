package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class NewAttributeForFragmentTemplateFlowGenerator extends FlowDesign {
	
	public static final NewAttributeForFragmentTemplateFlowGenerator FLOW = new NewAttributeForFragmentTemplateFlowGenerator();

	private NewAttributeForFragmentTemplateFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("NewAttributeForFragmentTemplate");
		setIsCustomized(true);
	}
}
