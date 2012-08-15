package org.instantlogic.engine.presence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presence extends AbstractPresence {

	private static final Logger logger = LoggerFactory.getLogger(Presence.class);
	
	public Place enter(Traveler traveler, String url) {
		traveler.setCurrentPlace(null);
		if (url==null) return null;
		traveler.placeUpdated();
		for (Place place : getActivePlaces()) {
			if (place.getUrl().equals(url)) {
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

	public void executeCommand(Traveler traveler, String command, Object data) {
		switch (command) {
			case "login":
				traveler.getTravelerInfo().setAuthenticatedUsername((String)data);
				break;
		}
	}
}
