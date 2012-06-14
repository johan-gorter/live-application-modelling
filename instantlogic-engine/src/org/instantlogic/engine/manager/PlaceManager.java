package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.ChangeContext.FieldChange;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;

public class PlaceManager {
	
	private List<TravelerInfo> travelers = new ArrayList<TravelerInfo>();

	private static final Map<String, Object> PLACE_NOT_FOUND = new LinkedHashMap<String, Object>();
	static  {
		PLACE_NOT_FOUND.put("id", "1");
		PLACE_NOT_FOUND.put("type", "Page");
		PLACE_NOT_FOUND.put("pageType", "error");
		PLACE_NOT_FOUND.put("reason", "notfound");
	}
	
	private final ApplicationManager application;
	private final CaseManager caseManager;
	private final String path;
	
	public PlaceManager(ApplicationManager application, CaseManager caseManager, String path) {
		this.application = application;
		this.caseManager = caseManager;
		this.path = path;
	}

	public Map<String, Object> render(TravelerInfo traveler) {
		RenderContext renderContext = findPage(traveler);
		if (renderContext==null) {
			return PLACE_NOT_FOUND;
		}
		PlaceTemplate placeTemplate = (PlaceTemplate)renderContext.getFlowContext().getFlowStack().getCurrentNode();
		return placeTemplate.render(renderContext);
	}
	
	public String submit(FieldChange[] changes, String submitId, TravelerInfo traveler) {
		ChangeContext changeContext = ChangeContext.create(application.getApplication().getMainFlow(), path, caseManager.getCase(), caseManager.getCaseId(), changes, submitId, traveler);
		PlaceTemplate placeTemplate = (PlaceTemplate)changeContext.getFlowContext().getFlowStack().getCurrentNode();
		FlowEventOccurrence eventOccurrence = placeTemplate.submit(changeContext);
		while (eventOccurrence!=null) {
			eventOccurrence = changeContext.getFlowContext().step(eventOccurrence);
		}
		return changeContext.getFlowContext().getFlowStack().toPath();
	}
	

	private RenderContext findPage(TravelerInfo traveler) {
		try {
			return RenderContext.create(application.getApplication().getMainFlow(), path, caseManager.getCase(), caseManager.getCaseId(), traveler);
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

	public void leave(TravelerInfo traveler) {
		this.travelers.remove(traveler);
		if (this.travelers.size()==0) {
			this.caseManager.deactivatePlace(this);
		}
	}

	public void enter(TravelerInfo traveler) {
		this.travelers.add(traveler);
	}
}
