package org.instantlogic.engine.manager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.instantlogic.engine.manager.PlaceManager.RenderedPage;
import org.instantlogic.engine.persistence.json.FileCasePersister;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.util.ChangeContext.FieldChange;
import org.instantlogic.interaction.util.TravelerInfo;

/**
 * At this point, synchronization takes place.
 */
public class CaseManager {

	private final String caseId;
	private Entity<? extends Instance> caseEntity;
	private ApplicationManager application;
	private Instance theCase;
	
	private final Map<String, PlaceManager> activePlaces = new HashMap<String, PlaceManager>();
	private final Presence presence;
	
	public CaseManager(ApplicationManager application, String caseId, Entity<? extends Instance> caseEntity) {
		if (caseId==null) caseId = FileCasePersister.uniqueId();
		this.caseId = caseId;
		this.caseEntity = caseEntity;
		this.application = application;
		this.presence = new Presence();
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
	public synchronized void enter(TravelerInfo traveler, String oldPath, String newPath) {
		if (oldPath!=null) {
			PlaceManager oldPlace = activePlaces.get(oldPath);
			oldPlace.leave(traveler);
		}
		getActivePlace(newPath).enter(traveler);
	}
	
	public synchronized RenderedPage render(TravelerInfo traveler, String path) {
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

	public synchronized String submit(TravelerInfo traveler, String path, FieldChange[] changes, String submitId) {
		PlaceManager place = getActivePlace(path);
		String newPath = place.submit(changes, submitId, traveler);
		enter(traveler, path, newPath);
		return newPath;
	}
	
	public Instance getCase() {
		return theCase;
	}

	public void deactivatePlace(PlaceManager placeManager) {
		this.activePlaces.remove(placeManager);
	}

	public void leave(String location, TravelerInfo traveler) {
		this.activePlaces.get(location).leave(traveler);
	}

	// Strange API due to the synchronization border
	public synchronized RenderedPage renderAndObserve(TravelerInfo travelerInfo, String location, ObservationsOutdatedObserver placeOutdatedObserverToRemove, ValueChangeObserver placeOutdatedValueChangeObserver) {
		if (placeOutdatedObserverToRemove!=null) {
			placeOutdatedObserverToRemove.remove();
		}
		RenderedPage renderedPage = render(travelerInfo, location); 
		renderedPage.placeOutdatedObserver = new ObservationsOutdatedObserver(renderedPage.observations, placeOutdatedValueChangeObserver);
		return renderedPage;
	}

	public Map<String, Object> renderPresence(TravelerInfo travelerInfo) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("applicationName", this.application.getApplication().getName());
		return result;
	}
}
