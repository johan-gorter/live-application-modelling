package org.instantlogic.engine.presence.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class UserEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.User> {

	public static final UserEntity INSTANCE = new UserEntity();
	

	
	@Override
	public org.instantlogic.engine.presence.User createInstance() {
		return new org.instantlogic.engine.presence.User();
	}
	
	@Override
	public Class<org.instantlogic.engine.presence.User> getInstanceClass() {
		return org.instantlogic.engine.presence.User.class;
	}
	
	@Override
	public String getName() {
		return "User";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.User, java.lang.String, java.lang.String> username 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.User, java.lang.String, java.lang.String>(
			"username", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.User, java.lang.String> get(org.instantlogic.engine.presence.User instance) {
				return instance.getUsernameAttributeValue();
			}
            
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence> presence
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence>(
			"presence", INSTANCE, org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE, org.instantlogic.engine.presence.Presence.class, org.instantlogic.engine.presence.entity.PresenceEntity.activeUsers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Presence> get(
					org.instantlogic.engine.presence.User instance) {
				return instance.getPresenceRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.User, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler> travelers
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.User, org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>, org.instantlogic.engine.presence.Traveler>(
			"travelers", INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.Traveler.class, org.instantlogic.engine.presence.entity.TravelerEntity.user
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.Traveler> get(
					org.instantlogic.engine.presence.User instance) {
				return instance.getTravelersRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		username,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		presence,
		travelers,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
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
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.engine.presence.User> getStaticInstances() {
		return org.instantlogic.engine.presence.User.getStaticUserInstances();
	}
}
