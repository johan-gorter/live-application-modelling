package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.AddEntityEventGenerator;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.event.HomeEventGenerator;
import org.instantlogic.designer.flow.main.WelcomePlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Main");
	}
	
	@Override
	public void init() {
		SubFlowDesign entitySubFlow = addSubFlow(EntityFlowGenerator.FLOW); 
		SubFlowDesign addEntitySubFlow = addSubFlow(AddEntityFlowGenerator.FLOW); 

		addToNodes(WelcomePlaceTemplateGenerator.PLACE);

		newEdge()
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(entitySubFlow);

		newEdge()
			.setEvent(AddEntityEventGenerator.EVENT)
			.setEndNode(addEntitySubFlow);
		
		newEdge()
			.setEvent(HomeEventGenerator.EVENT)
			.setEndNode(WelcomePlaceTemplateGenerator.PLACE);
		
		super.init();
	}
}
