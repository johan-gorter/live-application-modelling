package org.instantlogic.engine.presence;


public class User extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.UserEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> username
		= createAttributeValue(org.instantlogic.engine.presence.entity.UserEntity.username);
	
	public java.lang.String getUsername() {
		return username.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUsernameAttributeValue() {
		return username;
	}

	public User setUsername(java.lang.String newValue) {
		username.setValue(newValue);
		return (User)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Presence> presence
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.UserEntity.presence);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Presence> getPresenceRelationValue() {
		return presence;
	}

	public org.instantlogic.engine.presence.Presence getPresence() {
		return presence.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Traveler> travelers
		= createReverseRelationValues(org.instantlogic.engine.presence.entity.UserEntity.travelers);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Traveler> getTravelersRelationValue() {
		return travelers;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler> getTravelers() {
		return travelers.getValue();
	}


}
