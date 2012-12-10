package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.PlaceTemplateDesignEntityGenerator;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.AddAttributeEventGenerator;
import org.instantlogic.designer.event.CloseEditorEventGenerator;
import org.instantlogic.designer.event.OpenEditorEventGenerator;
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
		SubFlowDesign openEditorSubFlow = addSubFlow(OpenEditorFlowGenerator.FLOW);
		SubFlowDesign closeEditorSubFlow = addSubFlow(CloseEditorFlowGenerator.FLOW);
		SubFlowDesign newAttributeSubFlow = addSubFlow(NewAttributeForFragmentTemplateFlowGenerator.FLOW);
		
		newEdge()
			.setEvent(PlaceTemplateDetailsEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(OpenEditorEventGenerator.EVENT)
			.setEndNode(openEditorSubFlow);
		newEdge()
			.setStartNode(openEditorSubFlow)
			.setEvent(OpenEditorEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(CloseEditorEventGenerator.EVENT)
			.setEndNode(closeEditorSubFlow);
		newEdge()
			.setStartNode(closeEditorSubFlow)
			.setEvent(CloseEditorEventGenerator.EVENT)
			.setEndNode(PlaceTemplateDetailsPlaceGenerator.PLACE);

		newEdge()
			.setStartNode(PlaceTemplateDetailsPlaceGenerator.PLACE)
			.setEvent(AddAttributeEventGenerator.EVENT)
			.setEndNode(newAttributeSubFlow);
		
		super.init();
	}
}
