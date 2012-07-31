package org.instantlogic.engine.presence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presence extends AbstractPresence {

	private static final Logger logger = LoggerFactory.getLogger(Presence.class);
	
	public Place enter(Traveler traveler, String url) {
		if (traveler.getCurrentPlace()!=null) {
			Place oldPlace = traveler.getCurrentPlace();
			logger.debug("Traveler {} exits place {}", traveler.getId(), oldPlace.getUrl());
			traveler.setCurrentPlace(null);
			if (oldPlace.getVisitingTravelers().size()==0) {
				logger.debug("Deactivating place {}", traveler.getId(), oldPlace.getUrl());
				removeFromActivePlaces(oldPlace);
			}
		}
		if (url==null) return null;
		for (Place place : getActivePlaces()) {
			if (place.getUrl().equals(url)) {
				logger.debug("Traveler {} enters place {}", traveler.getId(), place.getUrl());
				traveler.setCurrentPlace(place);
				return place;
			}
		}
		Place place = new Place();
		place.setUrl(url);
		logger.debug("Activating place {}", traveler.getId(), place.getUrl());
		addToActivePlaces(place);
		traveler.setCurrentPlace(place);
		return place;
	}
}
