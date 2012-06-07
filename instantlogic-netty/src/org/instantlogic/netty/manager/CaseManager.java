package org.instantlogic.netty.manager;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.ChangeContext.FieldChange;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.netty.Traveler;

public class CaseManager {

	private final String caseId;
	private Entity<? extends Instance> caseEntity;
	private ApplicationManager application;
	private Instance theCase;
	
	private Map<String, PlaceManager> activePlaces = new HashMap<String, PlaceManager>();
	
	public CaseManager(ApplicationManager application, String caseId, Entity<? extends Instance> caseEntity) {
		if (caseId==null) caseId = FileCasePersister.uniqueId();
		this.caseId = caseId;
		this.caseEntity = caseEntity;
		this.application = application;
		this.theCase = FileCasePersister.INSTANCE.loadOrCreate(caseId, caseEntity.getInstanceClass());
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
	public synchronized void enter(Traveler traveler, String oldPath, String newPath) {
		if (oldPath!=null) {
			PlaceManager oldPlace = activePlaces.get(oldPath);
			oldPlace.leave(traveler);
		}
		getActivePlace(newPath).enter(traveler);
	}
	
	public synchronized Object render(Traveler traveler, String path) {
		PlaceManager newPlace = getActivePlace(path);
		return newPlace.render(traveler);
	}

	private PlaceManager getActivePlace(String path) {
		PlaceManager place = activePlaces.get(path);
		if (place==null) {
			place = new PlaceManager(application, this, path);
			activePlaces.put(path, place);
		}
		return place;
	}

	public synchronized String submit(Traveler traveler, String path, FieldChange[] changes, String submitId) {
		PlaceManager place = getActivePlace(path);
		String newPath = place.submit(changes, submitId);
		enter(traveler, path, newPath);
		return newPath;
	}
	
	public Instance getCase() {
		return theCase;
	}

	public void deactivatePlace(PlaceManager placeManager) {
		this.activePlaces.remove(placeManager);
	}

	public void leave(String location, Traveler traveler) {
		// TODO Auto-generated method stub
		
	}

}
