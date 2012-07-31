package org.instantlogic.engine.presence;


public class User extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.UserEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> userName
		= createAttributeValue(org.instantlogic.engine.presence.entity.UserEntity.userName);
	
	public java.lang.String getUserName() {
		return userName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUserNameAttributeValue() {
		return userName;
	}

	public User setUserName(java.lang.String newValue) {
		userName.setValue(newValue);
		return (User)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<User, Traveler> travelers
		= createRelationValues(org.instantlogic.engine.presence.entity.UserEntity.travelers);
		
	public org.instantlogic.fabric.value.RelationValues<User, Traveler> getTravelersRelationValue() {
		return travelers;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler> getTravelers() {
		return travelers.getValue();
	}
	
	public User addToTravelers(Traveler item) {
		travelers.addValue(item);
		return (User)this;
	}
	
	public User addToTravelers(Traveler item, int index) {
		travelers.insertValue(item, index);
		return (User)this;
	}
	
	public User removeFromTravelers(Traveler item) {
		travelers.removeValue(item);
		return (User)this;
	}
	
	public User removeFromTravelers(int index) {
		travelers.removeValue(index);
		return (User)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Presence> presence
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.UserEntity.presence);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Presence> getPresenceRelationValue() {
		return presence;
	}

	public org.instantlogic.engine.presence.Presence getPresence() {
		return presence.getValue();
	}


}
