package org.instantlogic.interaction;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.PageCoordinates;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;


public abstract class Application {
	
	private static final String[] NO_THEMES = new String[0];

	public abstract Entity<? extends Instance> getCaseEntity();
	
	public abstract String getName();
	
	public Flow getMainFlow() {
		return null;
	}

	public FlowEvent getStartEvent() {
		return null;
	}
	
	public String[] getThemeNames() {
		return NO_THEMES;
	}

	public FlowStack createFlowStack(PageCoordinates pageCoordinates, Instance caseInstance) {
		Iterator<Coordinate> coordinates = pageCoordinates.getPath().iterator();
		Coordinate next = coordinates.next();
		FlowStack flowStack = new FlowStack(null, getMainFlow());
		return getMainFlow().createFlowStack(flowStack, next, coordinates, caseInstance);
	}
}