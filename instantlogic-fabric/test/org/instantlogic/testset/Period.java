package org.instantlogic.testset;

import java.util.Date;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class Period extends Instance {

	public static class DaysBetweenRule extends Deduction<Integer> {

		private static final int MILLISECONDS_PER_DAY = 1000*60*60*24;

		@Override
		public ValueAndLevel<Integer> deduct(DeductionContext context) {
			Period period = context.getSelectedInstance(PeriodEntity.INSTANCE);
			Date from = period.getFrom();
			Date to = period.getTo();
			if (from==null || to==null) {
				return ValueAndLevel.inconclusive();
			}
			return ValueAndLevel.deduced((int)((to.getTime() - from.getTime())/MILLISECONDS_PER_DAY));
		}

	}
	
	
	public static class PeriodEntity extends Entity<Period> {

		public static final PeriodEntity INSTANCE = new PeriodEntity();

		// Attributes

		public static final Attribute<Period, java.util.Date, java.util.Date> from = new SimpleAttribute<Period, java.util.Date, java.util.Date>(
				"from", INSTANCE, java.util.Date.class) {

			@Override
			public ReadOnlyAttributeValue<Period, java.util.Date> get(
					Period instance) {
				return instance.from;
			}
		};

		public static final Attribute<Period, java.util.Date, java.util.Date> to = new SimpleAttribute<Period, java.util.Date, java.util.Date>(
				"to", INSTANCE, java.util.Date.class) {

			@Override
			public ReadOnlyAttributeValue<Period, java.util.Date> get(
					Period instance) {
				return instance.to;
			}
		};

		public static final Attribute<Period, java.lang.Integer, java.lang.Integer> daysBetween = new SimpleAttribute<Period, java.lang.Integer, java.lang.Integer>(
				"daysBetween", INSTANCE, java.lang.Integer.class) {

			@Override
			public ReadOnlyAttributeValue<Period, java.lang.Integer> get(
					Period instance) {
				return instance.daysBetween;
			}
			private final Deduction<Integer> RULE = new DaysBetweenRule();
			
			public Deduction<Integer> getRule() {
				return RULE;
			};
		};

		private static final Attribute[] ATTRIBUTES = new Attribute[] { from, to, daysBetween };
		private static final Relation[] RELATIONS = new Relation[] {};
		private static final Relation[] REVERSE_RELATIONS = new Relation[] {};

		@Override
		public Entity<?> extendsEntity() {
			return null;
		}

		@Override
		public Attribute<Period, ? extends Object, ? extends Object>[] getLocalAttributes() {
			return ATTRIBUTES;
		}

		@Override
		public Relation<Period, ? extends Object, ? extends Instance>[] getLocalRelations() {
			return RELATIONS;
		}

		@Override
		public Relation<? extends Instance, ? extends Object, Period>[] getLocalReverseRelations() {
			return REVERSE_RELATIONS;
		}

		@Override
		public Period createInstance() {
			return new Period();
		}

		@Override
		public String getName() {
			return "Period";
		}

		@Override
		public Class<Period> getInstanceClass() {
			return Period.class;
		}

	}

	@Override
	public Entity<Period> getInstanceEntity() {
		return PeriodEntity.INSTANCE;
	}

	public final AttributeValue<Period, java.util.Date> from = createAttributeValue(PeriodEntity.from);

	public final AttributeValue<Period, java.util.Date> to = createAttributeValue(PeriodEntity.to);

	public final ReadOnlyAttributeValue<Period, java.lang.Integer> daysBetween = createReadOnlyAttributeValue(PeriodEntity.daysBetween);
	
	public Date getFrom() {
		return from.getValue();
	}
	
	public void setFrom(Date from) {
		this.from.setValue(from);
	}

	public Date getTo() {
		return to.getValue();
	}

	public void setTo(Date from) {
		this.to.setValue(from);
	}

	public Integer getDaysBetween() {
		return daysBetween.getValue();
	}
	
	public ReadOnlyAttributeValue<Period, java.lang.Integer> getDaysBetweenAttribute() {
		return daysBetween;
	}
}
