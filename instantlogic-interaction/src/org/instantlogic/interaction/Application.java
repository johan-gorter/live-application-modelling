package org.instantlogic.interaction;

import java.util.Iterator;
import java.util.SortedMap;

import lbe.engine.FlowStack;
import lbe.engine.PageCoordinates;
import lbe.engine.PageCoordinates.Coordinate;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.CaseEntity;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;


public abstract class Application {
	
	public abstract Class<? extends CaseInstance> getCaseInstanceClass();
	
	public abstract String getName();
	
	public abstract CaseEntity getCaseModel();
	
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
