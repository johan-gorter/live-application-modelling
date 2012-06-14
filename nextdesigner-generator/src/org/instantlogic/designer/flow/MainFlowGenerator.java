package org.instantlogic.designer.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.flow.main.WelcomePlaceGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		setName("Main");
	}
	
	@Override
	public void registerApplication(ApplicationDesign application) {
		FlowSourceDesign source = new FlowSourceDesign();
		addToSources(source);
		
		SubFlowDesign entitySubFlow = new SubFlowDesign().setFlow(EntityFlowGenerator.FLOW);
		entitySubFlow.setName("Entity");

		addToNodes(WelcomePlaceGenerator.PLACE);
		addToNodes(entitySubFlow);
		
		addToEdges(new FlowEdgeDesign()
			.setStartNode(WelcomePlaceGenerator.PLACE)
			.setStartEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(entitySubFlow));
		super.registerApplication(application);
	}
}
