package lbe.model;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import lbe.engine.FlowContext;
import lbe.engine.FlowStack;
import lbe.engine.PageCoordinates;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.engine.PageElement;
import lbe.instance.CaseInstance;
import lbe.model.flow.Flow;


public abstract class Application {
	
	public abstract Class<? extends CaseInstance> getCaseInstanceClass();
	
	public abstract String getName();
	
	public abstract Entity getCaseModel();
	
	public abstract SortedMap<String, Entity> getEntities();
	
	public abstract Flow[] getExposedFlows();

	public Flow getExposedFlow(String startFlowName) {
		for (Flow flowModel: getExposedFlows()) {
			if (flowModel.getName().equals(startFlowName)) {
				return flowModel;
			}
		}
		throw new RuntimeException("Exposed flow not found. Name: "+startFlowName);
	}

	public FlowStack createFlowStack(PageCoordinates pageCoordinates, CaseInstance caseInstance) {
		Iterator<Coordinate> coordinates = pageCoordinates.getPath().iterator();
		Coordinate next = coordinates.next();
		Flow startFlow = getExposedFlow(next.getNodeName());
		FlowStack flowStack = new FlowStack(null, startFlow);
		return startFlow.createFlowStack(flowStack, next, coordinates, caseInstance);
	}
	
}
