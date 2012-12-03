package org.instantlogic.engine.presence.entity;

public class PresenceEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.Presence> {

	public static final PresenceEntity INSTANCE = new PresenceEntity();
	

	
	@Override
	public org.instantlogic.engine.presence.Presence createInstance() {
		return new org.instantlogic.engine.presence.Presence();
	}
	
	@Override
	public Class<org.instantlogic.engine.presence.Presence> getInstanceClass() {
		return org.instantlogic.engine.presence.Presence.class;
	}
	
	@Override
	public String getName() {
		return "Presence";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Presence, java.lang.String, java.lang.String> applicationName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Presence, java.lang.String, java.lang.String>(
			"applicationName", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Presence, java.lang.String> get(org.instantlogic.engine.presence.Presence instance) {
				return instance.getApplicationNameAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Presence, java.lang.String, java.lang.String> caseName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Presence, java.lang.String, java.lang.String>(
			"caseName", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Presence, java.lang.String> get(org.instantlogic.engine.presence.Presence instance) {
				return instance.getCaseNameAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Place>, org.instantlogic.engine.presence.Place> activePlaces
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Place>, org.instantlogic.engine.presence.Place>(
			"activePlaces", INSTANCE, org.instantlogic.engine.presence.entity.PlaceEntity.INSTANCE, org.instantlogic.engine.presence.Place.class, 
			org.instantlogic.engine.presence.entity.PlaceEntity.presence
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Place> get(
					org.instantlogic.engine.presence.Presence instance) {
				return instance.getActivePlacesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler> activeTravelers
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler>(
			"activeTravelers", INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.Traveler.class, 
			org.instantlogic.engine.presence.entity.TravelerEntity.presence
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Traveler> get(
					org.instantlogic.engine.presence.Presence instance) {
				return instance.getActiveTravelersRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>, org.instantlogic.engine.presence.User> activeUsers
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Presence, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>, org.instantlogic.engine.presence.User>(
			"activeUsers", INSTANCE, org.instantlogic.engine.presence.entity.UserEntity.INSTANCE, org.instantlogic.engine.presence.User.class, 
			org.instantlogic.engine.presence.entity.UserEntity.presence
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.User> get(
					org.instantlogic.engine.presence.Presence instance) {
				return instance.getActiveUsersRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		applicationName,
		caseName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		activePlaces,
		activeTravelers,
		activeUsers,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	
	@Override
	public java.util.Map<String, org.instantlogic.engine.presence.Presence> getStaticInstances() {
		return org.instantlogic.engine.presence.Presence.getStaticPresenceInstances();
	}
}
