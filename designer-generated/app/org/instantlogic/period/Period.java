package org.instantlogic.period;


public class Period extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.period.entity.PeriodEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Period, java.util.Date> from
		= createAttributeValue(org.instantlogic.period.entity.PeriodEntity.from);
	
	public java.util.Date getFrom() {
		return from.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Period, java.util.Date> getFromAttributeValue() {
		return from;
	}

	public Period setFrom(java.util.Date newValue) {
		from.setValue(newValue);
		return (Period)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Period, java.util.Date> to
		= createAttributeValue(org.instantlogic.period.entity.PeriodEntity.to);
	
	public java.util.Date getTo() {
		return to.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Period, java.util.Date> getToAttributeValue() {
		return to;
	}

	public Period setTo(java.util.Date newValue) {
		to.setValue(newValue);
		return (Period)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Period, java.lang.Integer> daysBetween
		= createAttributeValue(org.instantlogic.period.entity.PeriodEntity.daysBetween);
	
	public java.lang.Integer getDaysBetween() {
		return daysBetween.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Period, java.lang.Integer> getDaysBetweenAttributeValue() {
		return daysBetween;
	}

	public Period setDaysBetween(java.lang.Integer newValue) {
		daysBetween.setValue(newValue);
		return (Period)this;
	}
	
	
	// Relations

	// Reverse relations

}
