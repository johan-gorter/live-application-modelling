package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.flow.main.WelcomePlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Main");
	}
	
	@Override
	public void init() {
		SubFlowDesign entitySubFlow = new SubFlowDesign();
		entitySubFlow.setName("Entity");
		addToNodes(entitySubFlow);
		entitySubFlow.setFlow(EntityFlowGenerator.FLOW);

		addToNodes(WelcomePlaceTemplateGenerator.PLACE);
		
		FlowEdgeDesign edge = new FlowEdgeDesign();
		addToEdges(edge);
		edge.setStartNode(WelcomePlaceTemplateGenerator.PLACE)
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(entitySubFlow);
		super.init();
	}
}
