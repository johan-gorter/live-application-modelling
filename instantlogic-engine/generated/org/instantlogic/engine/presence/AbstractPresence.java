package org.instantlogic.engine.presence;


public abstract class AbstractPresence extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Presence, java.lang.String> applicationName
		= createAttributeValue(org.instantlogic.engine.presence.entity.PresenceEntity.applicationName);
	
	public java.lang.String getApplicationName() {
		return applicationName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Presence, java.lang.String> getApplicationNameAttributeValue() {
		return applicationName;
	}

	public Presence setApplicationName(java.lang.String newValue) {
		applicationName.setValue(newValue);
		return (Presence)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Presence, java.lang.String> caseName
		= createAttributeValue(org.instantlogic.engine.presence.entity.PresenceEntity.caseName);
	
	public java.lang.String getCaseName() {
		return caseName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Presence, java.lang.String> getCaseNameAttributeValue() {
		return caseName;
	}

	public Presence setCaseName(java.lang.String newValue) {
		caseName.setValue(newValue);
		return (Presence)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<Presence, Place> activePlaces
		= createRelationValues(org.instantlogic.engine.presence.entity.PresenceEntity.activePlaces);
		
	public org.instantlogic.fabric.value.RelationValues<Presence, Place> getActivePlacesRelationValue() {
		return activePlaces;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Place> getActivePlaces() {
		return activePlaces.getValue();
	}
	
	public Presence addToActivePlaces(Place item) {
		activePlaces.addValue(item);
		return (Presence)this;
	}
	
	public Presence addToActivePlaces(Place item, int index) {
		activePlaces.insertValue(item, index);
		return (Presence)this;
	}
	
	public Presence removeFromActivePlaces(Place item) {
		activePlaces.removeValue(item);
		return (Presence)this;
	}
	
	public Presence removeFromActivePlaces(int index) {
		activePlaces.removeValue(index);
		return (Presence)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<Presence, Traveler> activeTravelers
		= createRelationValues(org.instantlogic.engine.presence.entity.PresenceEntity.activeTravelers);
		
	public org.instantlogic.fabric.value.RelationValues<Presence, Traveler> getActiveTravelersRelationValue() {
		return activeTravelers;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler> getActiveTravelers() {
		return activeTravelers.getValue();
	}
	
	public Presence addToActiveTravelers(Traveler item) {
		activeTravelers.addValue(item);
		return (Presence)this;
	}
	
	public Presence addToActiveTravelers(Traveler item, int index) {
		activeTravelers.insertValue(item, index);
		return (Presence)this;
	}
	
	public Presence removeFromActiveTravelers(Traveler item) {
		activeTravelers.removeValue(item);
		return (Presence)this;
	}
	
	public Presence removeFromActiveTravelers(int index) {
		activeTravelers.removeValue(index);
		return (Presence)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<Presence, User> activeUsers
		= createRelationValues(org.instantlogic.engine.presence.entity.PresenceEntity.activeUsers);
		
	public org.instantlogic.fabric.value.RelationValues<Presence, User> getActiveUsersRelationValue() {
		return activeUsers;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User> getActiveUsers() {
		return activeUsers.getValue();
	}
	
	public Presence addToActiveUsers(User item) {
		activeUsers.addValue(item);
		return (Presence)this;
	}
	
	public Presence addToActiveUsers(User item, int index) {
		activeUsers.insertValue(item, index);
		return (Presence)this;
	}
	
	public Presence removeFromActiveUsers(User item) {
		activeUsers.removeValue(item);
		return (Presence)this;
	}
	
	public Presence removeFromActiveUsers(int index) {
		activeUsers.removeValue(index);
		return (Presence)this;
	}
	

	// Reverse relations

}
