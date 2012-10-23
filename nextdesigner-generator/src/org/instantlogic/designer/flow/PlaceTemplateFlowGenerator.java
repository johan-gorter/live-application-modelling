package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.PlaceTemplateDesignEntityGenerator;
import org.instantlogic.designer.event.PlaceTemplateDetailsEventGenerator;
import org.instantlogic.designer.flow.placetemplate.PlaceTemplateDetailsPlaceGenerator;

public class PlaceTemplateFlowGenerator extends FlowDesign {
	
	public static final PlaceTemplateFlowGenerator FLOW = new PlaceTemplateFlowGenerator();

	private PlaceTemplateFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("PlaceTemplate");
	}
	
	@Override
	public void init() {
		addToParameters(PlaceTemplateDesignEntityGenerator.ENTITY);

		addToNodes(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setEvent(PlaceTemplateDetailsEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);

		super.init();
	}
}
