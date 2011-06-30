package lbe.model;

import java.util.Iterator;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.engine.PageElement;
import lbe.instance.CaseInstance;
import lbe.model.flow.Flow;


public abstract class Application {
	
	public abstract Class<? extends CaseInstance> getCaseInstanceClass();
	
	public abstract String getName();
	
	public abstract Entity getCaseModel();
	
	public abstract Flow[] getExposedFlows();

	public Flow getExposedFlow(String startFlowName) {
		for (Flow flowModel: getExposedFlows()) {
			if (flowModel.getName().equals(startFlowName)) {
				return flowModel;
			}
		}
		throw new RuntimeException("Exposed flow not found. Name: "+startFlowName);
	}

	public void jumpToPage(FlowContext flowContext) {
		Iterator<Coordinate> iterator = flowContext.getPageCoordinates().getPath().iterator();
		Flow startFlow;
		Coordinate startFlowCoordinate;
		if (!iterator.hasNext()) {
			startFlow = getExposedFlows()[0];
			flowContext.getPageCoordinates().addCoordinate(new Coordinate(startFlow.getName(), null));
			String trigger = startFlow.flow(null, null, flowContext);
			if (trigger!=null) {
				throw new RuntimeException("TODO: implement flowing");
			}
		} else {
			startFlowCoordinate = iterator.next();
			// TODO: if not iterator.hasNext(), flow instead of jumpToPage
			startFlow = getExposedFlow(startFlowCoordinate.getNodeName());
			startFlow.jumpTo(flowContext, startFlowCoordinate, iterator);
		}
	}
	
}
