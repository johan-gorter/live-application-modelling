package org.instantlogic.designer.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.flow.main.WelcomePlaceGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}

	@Override
	public void init() {
		FlowSourceDesign source = new FlowSourceDesign();
		addToSources(source);
		
		addToNodes(WelcomePlaceGenerator.PLACE);
	}

}
