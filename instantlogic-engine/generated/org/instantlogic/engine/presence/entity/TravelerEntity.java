package org.instantlogic.engine.presence.entity;

public class TravelerEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.engine.presence.Traveler> {

	public static final TravelerEntity INSTANCE = new TravelerEntity();


	

	
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

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create(false);
		return d0;
	}

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Traveler, java.lang.Boolean, java.lang.Boolean> communicatorVisible 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Traveler, java.lang.Boolean, java.lang.Boolean>(
			"communicatorVisible", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Traveler, java.lang.Boolean> get(org.instantlogic.engine.presence.Traveler instance) {
				return instance.getCommunicatorVisibleAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction0();
                }
                return defaultDeduction;
            }
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Traveler, java.lang.Boolean, java.lang.Boolean> debugVisible 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Traveler, java.lang.Boolean, java.lang.Boolean>(
			"debugVisible", INSTANCE, java.lang.Boolean.class
		) {
			{
				dataType.put("category", "boolean");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Traveler, java.lang.Boolean> get(org.instantlogic.engine.presence.Traveler instance) {
				return instance.getDebugVisibleAttributeValue();
			}
			
			private final org.instantlogic.fabric.text.TextTemplate question = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("debug"));
			@Override
			public org.instantlogic.fabric.text.TextTemplate getQuestion() {
				return question;
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String> focus 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String>(
			"focus", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Traveler, java.lang.String> get(org.instantlogic.engine.presence.Traveler instance) {
				return instance.getFocusAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String> id 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.engine.presence.Traveler, java.lang.String, java.lang.String>(
			"id", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.engine.presence.Traveler, java.lang.String> get(org.instantlogic.engine.presence.Traveler instance) {
				return instance.getIdAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Place> currentPlace
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place, org.instantlogic.engine.presence.Place>(
			"currentPlace", INSTANCE, org.instantlogic.engine.presence.entity.PlaceEntity.INSTANCE, org.instantlogic.engine.presence.Place.class, 
			org.instantlogic.engine.presence.entity.PlaceEntity.visitingTravelers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Place> get(
					org.instantlogic.engine.presence.Traveler instance) {
				return instance.getCurrentPlaceRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.User> user
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User, org.instantlogic.engine.presence.User>(
			"user", INSTANCE, org.instantlogic.engine.presence.entity.UserEntity.INSTANCE, org.instantlogic.engine.presence.User.class, 
			org.instantlogic.engine.presence.entity.UserEntity.travelers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.User> get(
					org.instantlogic.engine.presence.Traveler instance) {
				return instance.getUserRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence> presence
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Presence, org.instantlogic.engine.presence.Presence>(
			"presence", INSTANCE, org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE, org.instantlogic.engine.presence.Presence.class, org.instantlogic.engine.presence.entity.PresenceEntity.activeTravelers
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.engine.presence.Traveler, org.instantlogic.engine.presence.Presence> get(
					org.instantlogic.engine.presence.Traveler instance) {
				return instance.getPresenceRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		communicatorVisible,
		debugVisible,
		focus,
		id,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		currentPlace,
		user,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		presence,
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
	public java.util.Map<String, org.instantlogic.engine.presence.Traveler> getStaticInstances() {
		return org.instantlogic.engine.presence.Traveler.getStaticTravelerInstances();
	}
}
