package org.instantlogic.engine.presence;


public abstract class AbstractTraveler extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.String> id
		= createAttributeValue(org.instantlogic.engine.presence.entity.TravelerEntity.id);
	
	public java.lang.String getId() {
		return id.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.String> getIdAttributeValue() {
		return id;
	}

	public Traveler setId(java.lang.String newValue) {
		id.setValue(newValue);
		return (Traveler)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<Traveler, Place> currentPlace
		= createRelationValue(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace);
		
	public org.instantlogic.fabric.value.RelationValue<Traveler, Place> getCurrentPlaceRelationValue() {
		return currentPlace;
	}

	public org.instantlogic.engine.presence.Place getCurrentPlace() {
		return currentPlace.getValue();
	}
	
	public Traveler setCurrentPlace(org.instantlogic.engine.presence.Place newValue) {
		currentPlace.setValue(newValue);
		return (Traveler)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<Traveler, User> user
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.TravelerEntity.user);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<Traveler, User> getUserRelationValue() {
		return user;
	}

	public org.instantlogic.engine.presence.User getUser() {
		return user.getValue();
	}
}
