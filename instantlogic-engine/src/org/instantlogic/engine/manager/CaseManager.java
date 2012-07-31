package org.instantlogic.engine.manager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.engine.Client;
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
 * Only a single thread access the CaseManager at the same time.
 */
public class CaseManager {

	private static final Logger logger = LoggerFactory.getLogger(CaseManager.class);
	
	public static class RenderedPage {
		public RenderedPage(Map<String, Object> content, Observations observations) {
			this.content = content;
			this.observations = observations;
		}
		public final Map<String, Object> content;
		public final Observations observations;
		public ObservationsOutdatedObserver placeOutdatedObserver;
	}
	
	private static final Map<String, Object> PLACE_NOT_FOUND = new LinkedHashMap<String, Object>();
	static  {
		PLACE_NOT_FOUND.put("id", "1");
		PLACE_NOT_FOUND.put("type", "Page");
		PLACE_NOT_FOUND.put("pageType", "error");
		PLACE_NOT_FOUND.put("reason", "notfound");
	}
	
	private final String caseId;
	private ApplicationManager application;
	private Instance theCase;

	/**
	 * Administration for users, travelers and places.
	 */
	private final Presence presence;
	
	public CaseManager(ApplicationManager application, String caseId) {
		if (caseId==null) caseId = FileCasePersister.uniqueId();
		this.caseId = caseId;
		this.application = application;
		this.presence = new Presence();
		this.theCase = FileCasePersister.INSTANCE.loadOrCreate(caseId, application.getApplication().getCaseEntity().getInstanceClass());
	}

	public void processMessage(Client client, Message message) {
		Traveler traveler = getTraveler(client.getTraveler());
		message.execute(traveler, this.presence, this.theCase);
	}

	public void sendUpdates() {
		// TODO Auto-generated method stub
		
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	/**
	 * Even if the path does not exist, the placeManager gets created.
	 * @param path
	 * @param newLocation 
	 * @return The rendered page
	 */
	public void goTo(TravelerInfo travelerInfo, String newPath) {
		Traveler traveler = getTraveler(travelerInfo);
		this.presence.enter(traveler, newPath);
	}
	
	// Strange API due to the synchronization border
	public RenderedPage renderAndObserve(TravelerInfo travelerInfo, ObservationsOutdatedObserver placeOutdatedObserverToRemove, ValueChangeObserver placeOutdatedValueChangeObserver) {
		Traveler traveler = getTraveler(travelerInfo);
		if (placeOutdatedObserverToRemove!=null) {
			placeOutdatedObserverToRemove.remove();
		}
		RenderedPage renderedPage = render(traveler, travelerInfo); 
		renderedPage.placeOutdatedObserver = new ObservationsOutdatedObserver(renderedPage.observations, placeOutdatedValueChangeObserver);
		return renderedPage;
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
	
	public RenderedPage render(TravelerInfo travelerInfo) {
		Traveler traveler = getTraveler(travelerInfo);
		return render(traveler, travelerInfo);
	}
	
	private RenderedPage render(Traveler traveler, TravelerInfo travelerInfo) {
		RenderContext renderContext = findPage(traveler, travelerInfo);
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

	private Traveler getTraveler(TravelerInfo travelerInfo) {
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
		Traveler traveler = new Traveler();
		traveler.setId(travelerInfo.getTravelerId());
		user.addToTravelers(traveler);
		return traveler;
	}

	public Instance getCase() {
		return theCase;
	}
}
