package org.instantlogic.engine.presence;


public abstract class AbstractTraveler extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Traveler> _staticInstances = new java.util.LinkedHashMap<String, Traveler>();
	
	public static java.util.Map<String, Traveler> getStaticTravelerInstances() {
		return _staticInstances;
	}
	
	private static Traveler addStaticInstance(String name, Traveler instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.Boolean> communicatorVisible
		= createAttributeValue(org.instantlogic.engine.presence.entity.TravelerEntity.communicatorVisible);
	
	public java.lang.Boolean getCommunicatorVisible() {
		return communicatorVisible.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.Boolean> getCommunicatorVisibleAttributeValue() {
		return communicatorVisible;
	}

	public Traveler setCommunicatorVisible(java.lang.Boolean newValue) {
		communicatorVisible.setValue(newValue);
		return (Traveler)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.Boolean> debugVisible
		= createAttributeValue(org.instantlogic.engine.presence.entity.TravelerEntity.debugVisible);
	
	public java.lang.Boolean getDebugVisible() {
		return debugVisible.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.Boolean> getDebugVisibleAttributeValue() {
		return debugVisible;
	}

	public Traveler setDebugVisible(java.lang.Boolean newValue) {
		debugVisible.setValue(newValue);
		return (Traveler)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.String> focus
		= createAttributeValue(org.instantlogic.engine.presence.entity.TravelerEntity.focus);
	
	public java.lang.String getFocus() {
		return focus.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Traveler, java.lang.String> getFocusAttributeValue() {
		return focus;
	}

	public Traveler setFocus(java.lang.String newValue) {
		focus.setValue(newValue);
		return (Traveler)this;
	}
	
	
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
	
	public org.instantlogic.engine.presence.Place newCurrentPlace() {
		org.instantlogic.engine.presence.Place newValue = new org.instantlogic.engine.presence.Place(); 
		currentPlace.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<Traveler, User> user
		= createRelationValue(org.instantlogic.engine.presence.entity.TravelerEntity.user);
		
	public org.instantlogic.fabric.value.RelationValue<Traveler, User> getUserRelationValue() {
		return user;
	}

	public org.instantlogic.engine.presence.User getUser() {
		return user.getValue();
	}
	
	public Traveler setUser(org.instantlogic.engine.presence.User newValue) {
		user.setValue(newValue);
		return (Traveler)this;
	}
	
	public org.instantlogic.engine.presence.User newUser() {
		org.instantlogic.engine.presence.User newValue = new org.instantlogic.engine.presence.User(); 
		user.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<Traveler, Presence> presence
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.TravelerEntity.presence);

	public org.instantlogic.fabric.value.RelationValue<Traveler, Presence> getPresenceRelationValue() {
		return presence;
	}

	public org.instantlogic.engine.presence.Presence getPresence() {
		return presence.getValue();
	}

    public Traveler setPresence(org.instantlogic.engine.presence.Presence newValue) {
        presence.setValue(newValue);
        return (Traveler)this;
    }


}
