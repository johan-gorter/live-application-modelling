package org.instantlogic.engine.presence.entity;

public class PlaceEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.Place> {

	public static final PlaceEntity INSTANCE = new PlaceEntity();
	
	protected PlaceEntity() {
	}


	@Override
	public org.instantlogic.engine.presence.Place createInstance() {
		return new org.instantlogic.engine.presence.Place();
	}
	
	@Override
	public Class<org.instantlogic.engine.presence.Place> getInstanceClass() {
		return org.instantlogic.engine.presence.Place.class;
	}
	
	@Override
	public String getName() {
		return "Place";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Place, java.lang.String, java.lang.String> description 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Place, java.lang.String, java.lang.String>(
			"description", INSTANCE, java.lang.String.class
		) {

			{
				dataType.put("category", "text");
			}
			
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Place, java.lang.String> get(org.instantlogic.engine.presence.Place instance) {
				return instance.getDescriptionAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Place, java.lang.String, java.lang.String> url 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Place, java.lang.String, java.lang.String>(
			"url", INSTANCE, java.lang.String.class
		) {

			{
				dataType.put("category", "text");
			}
			
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Place, java.lang.String> get(org.instantlogic.engine.presence.Place instance) {
				return instance.getUrlAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence> presence
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence>(
			"presence", INSTANCE, org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE, org.instantlogic.engine.presence.Presence.class, org.instantlogic.engine.presence.entity.PresenceEntity.activePlaces
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Presence> get(
					org.instantlogic.engine.presence.Place instance) {
				return instance.getPresenceRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Place, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler> visitingTravelers
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Place, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler>(
			"visitingTravelers", INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.Traveler.class, org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Traveler> get(
					org.instantlogic.engine.presence.Place instance) {
				return instance.getVisitingTravelersRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		description,
		url,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		presence,
		visitingTravelers,
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
