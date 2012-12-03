package org.instantlogic.engine.presence;


public abstract class AbstractPlace extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Place> _staticInstances = new java.util.LinkedHashMap<String, Place>();
	
	public static java.util.Map<String, Place> getStaticPlaceInstances() {
		return _staticInstances;
	}
	
	private static Place addStaticInstance(String name, Place instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.engine.presence.entity.PlaceEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Place, java.lang.String> description
		= createAttributeValue(org.instantlogic.engine.presence.entity.PlaceEntity.description);
	
	public java.lang.String getDescription() {
		return description.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Place, java.lang.String> getDescriptionAttributeValue() {
		return description;
	}

	public Place setDescription(java.lang.String newValue) {
		description.setValue(newValue);
		return (Place)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Place, java.lang.String> url
		= createAttributeValue(org.instantlogic.engine.presence.entity.PlaceEntity.url);
	
	public java.lang.String getUrl() {
		return url.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Place, java.lang.String> getUrlAttributeValue() {
		return url;
	}

	public Place setUrl(java.lang.String newValue) {
		url.setValue(newValue);
		return (Place)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<Place, Presence> presence
		= createReverseRelationValue(org.instantlogic.engine.presence.entity.PlaceEntity.presence);

	public org.instantlogic.fabric.value.RelationValue<Place, Presence> getPresenceRelationValue() {
		return presence;
	}

	public org.instantlogic.engine.presence.Presence getPresence() {
		return presence.getValue();
	}

    public Place setPresence(org.instantlogic.engine.presence.Presence newValue) {
        presence.setValue(newValue);
        return (Place)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<Place, Traveler> visitingTravelers
		= createReverseRelationValues(org.instantlogic.engine.presence.entity.PlaceEntity.visitingTravelers);

	public org.instantlogic.fabric.value.RelationValues<Place, Traveler> getVisitingTravelersRelationValue() {
		return visitingTravelers;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler> getVisitingTravelers() {
		return visitingTravelers.getValue();
	}

    public Place addToVisitingTravelers(Traveler item) {
        visitingTravelers.addValue(item);
        return (Place)this;
    }

    public Place removeFromVisitingTravelers(Traveler item) {
        visitingTravelers.removeValue(item);
        return (Place)this;
    }


}
