package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.persistence.json.FileCasePersister;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.engine.presence.User;
import org.instantlogic.engine.presence.flow.MainFlow;
import org.instantlogic.engine.presence.flow.main.PresencePlaceTemplate;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.ChangeContext.FieldChange;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Only a single thread accesses the CaseManager at the same time.
 */
public class CaseManager {

	private static final Logger logger = LoggerFactory.getLogger(CaseManager.class);
	
	private final String caseId;
	/**
	 * Administration for users, travelers and places.
	 */
	private final Presence presence;
	private final ApplicationManager application;
	private final Instance theCase;
	
	public CaseManager(ApplicationManager application, String caseId) {
		if (caseId==null) caseId = FileCasePersister.uniqueId();
		this.caseId = caseId;
		this.application = application;
		this.presence = new Presence();
		this.theCase = FileCasePersister.INSTANCE.loadOrCreate(caseId, application.getApplication().getCaseEntity().getInstanceClass());
	}

	public void processMessage(TravelerProxy travelerProxy, Message message) {
		Traveler traveler = getTraveler(travelerProxy);
		message.execute(traveler, this.presence, this.theCase);
	}

	public void sendUpdates() {
		// Render the places (this may update the place titles needed for rendering the presence)
		for (User user : this.presence.getUsers()) {
			for (Traveler traveler: user.getTravelers()) {
				traveler.queuePlaceIfNeeded();
			}
		}
		// Render the presence and send
		for (User user : this.presence.getUsers()) {
			for (Traveler traveler: user.getTravelers()) {
				traveler.queuePresenceIfNeeded();
				traveler.sendQueuedUpdates();
			}
		}
	}
	
	
	public Map<String, Object> renderPresence(TravelerInfo travelerInfo) {
		Traveler traveler = getTraveler(travelerInfo);
		FlowContext flowContext = new FlowContext(this.presence, "presence", travelerInfo);
		FlowStack flowStack = new FlowStack(null, MainFlow.INSTANCE);
		flowStack.pushSelectedInstance(traveler.getUser());
		flowContext.setFlowStack(flowStack);
		RenderContext renderContext = new RenderContext(flowContext, traveler.getUser().getMetadata().getInstanceId()+"/Presence");
		CaseAdministration caseAdministration = presence.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		Map<String, Object> result = PresencePlaceTemplate.INSTANCE.render(renderContext);
		Observations observations = caseAdministration.stopRecordingObservations();
		return result;
	}
	
	public RenderedPage render(TravelerProxy travelerProxy) {
		Traveler traveler = getTraveler(travelerProxy);
		return render(traveler, travelerProxy);
	}
	
	private RenderedPage render(Traveler traveler, TravelerProxy travelerProxy) {
		RenderContext renderContext = findPage(traveler, travelerProxy);
		if (renderContext==null) {
			return new RenderedPage(PLACE_NOT_FOUND, new Observations());
		}
		PlaceTemplate placeTemplate = (PlaceTemplate)renderContext.getFlowContext().getFlowStack().getCurrentNode();
		
		CaseAdministration caseAdministration = renderContext.getCaseInstance().getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		Map<String, Object> content = placeTemplate.render(renderContext);
		Observations observations = caseAdministration.stopRecordingObservations();
		return new RenderedPage(content, observations);
	}
	
	public String submit(TravelerInfo traveler, String path, FieldChange[] changes, String submitId) {
		CaseAdministration caseAdministration = this.theCase.getMetadata().getCaseAdministration();
		Operation operation = caseAdministration.startOperation();
		try {
			ChangeContext changeContext = ChangeContext.create(application.getApplication().getMainFlow(), path, theCase, caseId, changes, submitId, traveler);
			PlaceTemplate placeTemplate = (PlaceTemplate)changeContext.getFlowContext().getFlowStack().getCurrentNode();
			FlowEventOccurrence eventOccurrence = placeTemplate.submit(changeContext);
			while (eventOccurrence!=null) {
				eventOccurrence = changeContext.getFlowContext().step(eventOccurrence);
			}
			operation.complete();
			return changeContext.getFlowContext().getFlowStack().toPath();
		} finally {
			operation.close();
		}
	}
	

	private RenderContext findPage(Traveler traveler, TravelerInfo travelerInfo) {
		try {
			return RenderContext.create(application.getApplication().getMainFlow(), traveler.getCurrentPlace().getUrl(), theCase, caseId, travelerInfo);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	private Traveler getTraveler(TravelerProxy travelerProxy) {
		TravelerInfo travelerInfo = travelerProxy.getTravelerInfo();
		User user = null;
		for (User userKandidate: presence.getUsers()) {
			if (userKandidate.getUserName().equals(travelerInfo.getAuthenticatedUsername())) {
				user = userKandidate;
				break;
			}
		}
		if (user==null) {
			user = new User();
			user.setUserName(travelerInfo.getAuthenticatedUsername());
			presence.addToUsers(user);
		}
		for (Traveler traveler: user.getTravelers()) {
			if (traveler.getId().equals(travelerInfo.getTravelerId())) {
				return traveler;
			}
		}
		Traveler traveler = new Traveler(travelerProxy);
		traveler.setId(travelerInfo.getTravelerId());
		user.addToTravelers(traveler);
		return traveler;
	}

	public Instance getCase() {
		return theCase;
	}

	public ApplicationManager getApplicationManager() {
		return application;
	}
	
	public String getCaseId() {
		return caseId;
	}
}
