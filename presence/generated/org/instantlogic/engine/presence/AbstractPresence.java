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
	
	
	private final org.instantlogic.fabric.value.RelationValues<Presence, User> users
		= createRelationValues(org.instantlogic.engine.presence.entity.PresenceEntity.users);
		
	public org.instantlogic.fabric.value.RelationValues<Presence, User> getUsersRelationValue() {
		return users;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User> getUsers() {
		return users.getValue();
	}
	
	public Presence addToUsers(User item) {
		users.addValue(item);
		return (Presence)this;
	}
	
	public Presence addToUsers(User item, int index) {
		users.insertValue(item, index);
		return (Presence)this;
	}
	
	public Presence removeFromUsers(User item) {
		users.removeValue(item);
		return (Presence)this;
	}
	
	public Presence removeFromUsers(int index) {
		users.removeValue(index);
		return (Presence)this;
	}
	

	// Reverse relations

}
