package org.instantlogic.engine.manager;

import java.util.NoSuchElementException;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.persistence.json.FileCasePersister;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.engine.presence.User;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;
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
		message.execute(application.getApplication(), traveler, this.presence, this.theCase);
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
	
	public String submit(TravelerInfo traveler, String path, String submitId) {
		CaseAdministration caseAdministration = this.theCase.getMetadata().getCaseAdministration();
		Operation operation = caseAdministration.startOperation();
		try {
			SubmitContext submitContext = SubmitContext.create(application.getApplication().getMainFlow(), path, theCase, caseId, submitId, traveler);
			PlaceTemplate placeTemplate = (PlaceTemplate)submitContext.getFlowContext().getFlowStack().getCurrentNode();
			FlowEventOccurrence eventOccurrence = placeTemplate.submit(submitContext);
			while (eventOccurrence!=null) {
				eventOccurrence = submitContext.getFlowContext().step(eventOccurrence);
			}
			operation.complete();
			return submitContext.getFlowContext().getFlowStack().toPath();
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
		Traveler traveler = new Traveler(travelerProxy, this);
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

	public Presence getPresence() {
		return this.presence;
	}
}
