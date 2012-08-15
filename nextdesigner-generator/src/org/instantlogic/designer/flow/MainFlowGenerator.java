package org.instantlogic.designer.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.flow.main.WelcomePlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		SubFlowDesign entitySubFlow = new SubFlowDesign().setFlow(EntityFlowGenerator.FLOW);
		entitySubFlow.setName("Entity");

		addToNodes(WelcomePlaceTemplateGenerator.PLACE);
		addToNodes(entitySubFlow);
		
		addToEdges(new FlowEdgeDesign()
			.setStartNode(WelcomePlaceTemplateGenerator.PLACE)
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(entitySubFlow));
		super.registerApplication(application);
	}
}
