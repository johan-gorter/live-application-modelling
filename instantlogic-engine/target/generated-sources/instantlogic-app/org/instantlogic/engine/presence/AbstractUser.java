package org.instantlogic.engine.presence;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractUser extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, User> _staticInstances = new java.util.LinkedHashMap<String, User>();
	
	public static java.util.Map<String, User> getStaticUserInstances() {
		return _staticInstances;
	}
	
	private static User addStaticInstance(String name, User instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
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
	
	private final org.instantlogic.fabric.value.RelationValue<User, Presence> presence
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.UserEntity.presence);

	public org.instantlogic.fabric.value.RelationValue<User, Presence> getPresenceRelationValue() {
		return presence;
	}

	public org.instantlogic.engine.presence.Presence getPresence() {
		return presence.getValue();
	}

    public User setPresence(org.instantlogic.engine.presence.Presence newValue) {
        presence.setValue(newValue);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<User, Traveler> travelers
		= createReverseRelationValues(org.instantlogic.engine.presence.entity.UserEntity.travelers);

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

    public User removeFromTravelers(Traveler item) {
        travelers.removeValue(item);
        return (User)this;
    }


}
