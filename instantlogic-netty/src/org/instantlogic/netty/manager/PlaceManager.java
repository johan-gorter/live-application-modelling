package org.instantlogic.netty.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.Place;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.netty.Traveler;

import com.google.gson.JsonObject;

public class PlaceManager {
	
	private List<Traveler> travelers = new ArrayList<Traveler>();

	private static final JsonObject PLACE_NOT_FOUND = new JsonObject();
	static  {
		PLACE_NOT_FOUND.addProperty("id", "1");
		PLACE_NOT_FOUND.addProperty("widget", "page");
		PLACE_NOT_FOUND.addProperty("type", "error");
		PLACE_NOT_FOUND.addProperty("reason", "notfound");
	}
	
	private final ApplicationManager application;
	private final CaseManager caseManager;
	private final String path;
	private final String[] pathElements;
	
	public PlaceManager(ApplicationManager application, CaseManager caseManager, String path) {
		this.application = application;
		this.caseManager = caseManager;
		this.path = path;
		this.pathElements = path.split("/");
	}

	public Object render(Traveler traveler) {
		RenderContext renderContext = findPage();
		if (renderContext==null) {
			return PLACE_NOT_FOUND;
		}
		Place place = (Place)renderContext.getFlowContext().getFlowStack().getCurrentNode();
		return place.render(renderContext);
	}

	private RenderContext findPage() {
		try {
			Flow flow = application.getApplication().getExposedFlow(pathElements[0]);
			Iterator<String> iterator = Arrays.asList(pathElements).iterator();
			iterator.next();
			FlowStack flowStack = flow.createFlowStack(null, pathElements[0], iterator, caseManager.getCase());
			FlowContext flowContext = new FlowContext(caseManager.getCase(), caseManager.getCaseId());
			flowContext.setFlowStack(flowStack);
			if (flowStack.getCurrentNode()==null) {
				return null;
			}
			return new RenderContext(flowContext, this.path);
		} catch (NoSuchElementException e) {
			return null;
		}
	}
		
//		if (flowStack.getCurrentNode()==null) { // Not on a page, enter the flow until a page is reached
//			FlowEventOccurrence occurrence = new FlowEventOccurrence(null);
//			do {
//				occurrence = flowContext.step(occurrence);
//			} while (occurrence!=null);
//			flowContext.getFlowStack().toPageCoordinates();
//			
//		}
//		return new RenderContext(flowContext, this.path);
//	}

	public void leave(Traveler traveler) {
		this.travelers.remove(traveler);
		if (this.travelers.size()==0) {
			this.caseManager.deactivatePlace(this);
		}
	}
}
