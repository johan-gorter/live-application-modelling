package org.instantlogic.engine.presence;

public class Presence extends AbstractPresence {

	public Place enter(Traveler traveler, String url) {
		if (traveler.getCurrentPlace()!=null) {
			Place oldPlace = traveler.getCurrentPlace();
			traveler.setCurrentPlace(null);
			if (oldPlace.getVisitingTravelers().size()==0) {
				removeFromActivePlaces(oldPlace);
			}
		}
		if (url==null) return null;
		for (Place place : getActivePlaces()) {
			if (place.getUrl().equals(url)) {
				traveler.setCurrentPlace(place);
				return place;
			}
		}
		Place place = new Place();
		place.setUrl(url);
		addToActivePlaces(place);
		traveler.setCurrentPlace(place);
		return place;
	}
}
