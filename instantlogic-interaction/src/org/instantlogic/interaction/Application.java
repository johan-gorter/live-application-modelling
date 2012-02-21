package org.instantlogic.interaction;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.PageCoordinates;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;


public abstract class Application {
	
	public abstract Entity<? extends Instance> getCaseEntity();
	
	public abstract String getName();
	
	public abstract Flow[] getExposedFlows();

	public Flow getExposedFlow(String startFlowName) {
		for (Flow flowModel: getExposedFlows()) {
			if (flowModel.getName().equals(startFlowName)) {
				return flowModel;
			}
		}
		throw new RuntimeException("Exposed flow not found. Name: "+startFlowName);
	}

	public FlowStack createFlowStack(PageCoordinates pageCoordinates, Instance caseInstance) {
		Iterator<Coordinate> coordinates = pageCoordinates.getPath().iterator();
		Coordinate next = coordinates.next();
		Flow startFlow = getExposedFlow(next.getNodeName());
		FlowStack flowStack = new FlowStack(null, startFlow);
		return startFlow.createFlowStack(flowStack, next, coordinates, caseInstance);
	}
}
