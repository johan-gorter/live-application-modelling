package org.instantlogic.engine.manager;

import java.util.Arrays;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.persistence.json.FileCasePersister;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.engine.presence.User;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
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
		this.presence.setApplicationName(application.getApplication().getName());
		this.presence.setCaseName(caseId);
		this.theCase = FileCasePersister.INSTANCE.loadOrCreate(caseId, application.getApplication().getCaseEntity().getInstanceClass());
	}

	public void sendUpdates() {
		// Render the places (this may update the place titles needed for rendering the presence)
		for (Traveler traveler: presence.getActiveTravelers()) {
			try {
				traveler.queuePlaceIfNeeded();
			} catch (Exception e) {
				logger.error("Exception sending updates to traveler " + traveler.getId(), e);
				traveler.sendException(e, true);
			}
		}
		// Render the presence and send
		for (Traveler traveler: presence.getActiveTravelers()) {
			try {
				traveler.queuePresenceIfNeeded();
			} catch (Exception e) {
				logger.error("Exception sending presence to traveler " + traveler.getId(), e);
				traveler.sendException(e, true);
			}
			traveler.sendQueuedUpdates();
		}
	}
	
	public void processMessages(TravelerProxy travelerProxy, Message... messages) {
		processMessages(travelerProxy, Arrays.asList(messages));
	}
	
	public void processMessages(TravelerProxy travelerProxy, List<Message> messages) {
		CaseAdministration caseAdministration = this.theCase.getMetadata().getCaseAdministration();
		CaseAdministration presenceCaseAdministration = presence.getMetadata().getCaseAdministration();
		Traveler traveler = presence.getTraveler(travelerProxy, this);
		try {
			Operation operation = caseAdministration.startOperation();
			Operation presenceOperation = presenceCaseAdministration.startOperation();
			try {
				for (Message message:messages) {
					message.execute(application.getApplication(), traveler, this.presence, this.theCase);
				}
				operation.complete();
				presenceOperation.complete();
			} finally {
				operation.close();
				presenceOperation.close();
			}
		} catch (Exception e) {
			logger.error("Exception processing messages from traveler " + traveler.getId(), e);
			traveler.sendException(e, false);
		}
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
