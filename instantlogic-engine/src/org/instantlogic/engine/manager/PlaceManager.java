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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaceManager {
	
	private static final Logger logger = LoggerFactory.getLogger(PlaceManager.class);
	
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
	private final String location;
	
	public PlaceManager(ApplicationManager application, CaseManager caseManager, String path) {
		this.application = application;
		this.caseManager = caseManager;
		this.location = path;
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
		ChangeContext changeContext = ChangeContext.create(application.getApplication().getMainFlow(), location, caseManager.getCase(), caseManager.getCaseId(), changes, submitId, traveler);
		PlaceTemplate placeTemplate = (PlaceTemplate)changeContext.getFlowContext().getFlowStack().getCurrentNode();
		FlowEventOccurrence eventOccurrence = placeTemplate.submit(changeContext);
		while (eventOccurrence!=null) {
			eventOccurrence = changeContext.getFlowContext().step(eventOccurrence);
		}
		return changeContext.getFlowContext().getFlowStack().toPath();
	}
	

	private RenderContext findPage(TravelerInfo traveler) {
		try {
			return RenderContext.create(application.getApplication().getMainFlow(), location, caseManager.getCase(), caseManager.getCaseId(), traveler);
		} catch (NoSuchElementException e) {
			return null;
		}
	}
		
	public void leave(TravelerInfo traveler) {
		this.travelers.remove(traveler);
		if (this.travelers.size()==0) {
			logger.debug("Place {} got deactivated", this.location);
			this.caseManager.deactivatePlace(this);
		}
	}

	public void enter(TravelerInfo traveler) {
		logger.debug("Traveler {} enters place {}", traveler.getTravelerId(), this.location);
		this.travelers.add(traveler);
	}
}
