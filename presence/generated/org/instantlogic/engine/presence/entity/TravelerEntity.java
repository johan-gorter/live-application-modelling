package org.instantlogic.engine.presence.entity;

public class TravelerEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.Traveler> {

	public static final TravelerEntity INSTANCE = new TravelerEntity();
	
	protected TravelerEntity() {
	}


	@Override
	public org.instantlogic.engine.presence.Traveler createInstance() {
		return new org.instantlogic.engine.presence.Traveler();
	}
	
	@Override
	public Class<org.instantlogic.engine.presence.Traveler> getInstanceClass() {
		return org.instantlogic.engine.presence.Traveler.class;
	}
	
	@Override
	public String getName() {
		return "Traveler";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String> id 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String>(
			"id", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Traveler, java.lang.String> get(org.instantlogic.engine.presence.Traveler instance) {
				return instance.getIdAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Place> currentPlace
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Place>(
			"currentPlace", INSTANCE, org.instantlogic.engine.presence.entity.PlaceEntity.INSTANCE, org.instantlogic.engine.presence.Place.class, org.instantlogic.engine.presence.entity.PlaceEntity.visitingTravelers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place> get(
					org.instantlogic.engine.presence.Traveler instance) {
				return instance.getCurrentPlaceRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.User> user
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.User>(
			"user", INSTANCE, org.instantlogic.engine.presence.entity.UserEntity.INSTANCE, org.instantlogic.engine.presence.User.class, org.instantlogic.engine.presence.entity.UserEntity.travelers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User> get(
					org.instantlogic.engine.presence.Traveler instance) {
				return instance.getUserRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		id,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		currentPlace,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		user,
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
