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
	
	public abstract Flow getMainFlow();

	public FlowStack createFlowStack(PageCoordinates pageCoordinates, Instance caseInstance) {
		Iterator<Coordinate> coordinates = pageCoordinates.getPath().iterator();
		Coordinate next = coordinates.next();
		FlowStack flowStack = new FlowStack(null, getMainFlow());
		return getMainFlow().createFlowStack(flowStack, next, coordinates, caseInstance);
	}
}
