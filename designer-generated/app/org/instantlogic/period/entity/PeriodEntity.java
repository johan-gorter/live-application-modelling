package org.instantlogic.period.entity;

public class PeriodEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.period.Period> {

	public static final PeriodEntity INSTANCE = new PeriodEntity();
	
	protected PeriodEntity() {
	}


	@Override
	public org.instantlogic.period.Period createInstance() {
		return new org.instantlogic.period.Period();
	}
	
	@Override
	public Class<org.instantlogic.period.Period> getInstanceClass() {
		return org.instantlogic.period.Period.class;
	}
	
	@Override
	public String getName() {
		return "Period";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.period.Period, java.util.Date, java.util.Date> from 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.period.Period, java.util.Date, java.util.Date>(
			"from", INSTANCE, java.util.Date.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.period.Period, java.util.Date> get(org.instantlogic.period.Period instance) {
				return instance.getFromAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.period.Period, java.util.Date, java.util.Date> to 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.period.Period, java.util.Date, java.util.Date>(
			"to", INSTANCE, java.util.Date.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.period.Period, java.util.Date> get(org.instantlogic.period.Period instance) {
				return instance.getToAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.period.Period, java.lang.Integer, java.lang.Integer> daysBetween 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.period.Period, java.lang.Integer, java.lang.Integer>(
			"daysBetween", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.period.Period, java.lang.Integer> get(org.instantlogic.period.Period instance) {
				return instance.getDaysBetweenAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		from,
		to,
		daysBetween,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
}
