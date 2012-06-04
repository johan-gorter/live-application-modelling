package org.instantlogic.netty.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.netty.Traveler;

import com.google.gson.JsonObject;

public class PlaceManager {
	
	private List<Traveler> travelers = new ArrayList<Traveler>();

	private static final JsonObject PLACE_NOT_FOUND = new JsonObject();
	static  {
		PLACE_NOT_FOUND.addProperty("id", "1");
		PLACE_NOT_FOUND.addProperty("fragmentType", "page");
		PLACE_NOT_FOUND.addProperty("pageType", "error");
		PLACE_NOT_FOUND.addProperty("reason", "notfound");
	}
	
	private final ApplicationManager application;
	private final CaseManager caseManager;
	private final String path;
	
	public PlaceManager(ApplicationManager application, CaseManager caseManager, String path) {
		this.application = application;
		this.caseManager = caseManager;
		this.path = path;
	}

	public Object render(Traveler traveler) {
		RenderContext renderContext = findPage();
		if (renderContext==null) {
			return PLACE_NOT_FOUND;
		}
		PlaceTemplate placeTemplate = (PlaceTemplate)renderContext.getFlowContext().getFlowStack().getCurrentNode();
		return placeTemplate.render(renderContext);
	}

	private RenderContext findPage() {
		try {
			return RenderContext.create(application.getApplication().getMainFlow(), path, caseManager.getCase(), caseManager.getCaseId());
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
