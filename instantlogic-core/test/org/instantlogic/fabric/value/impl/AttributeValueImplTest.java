package org.instantlogic.fabric.value.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeListener;
import org.instantlogic.testset.Period;
import org.junit.Before;
import org.junit.Test;

public class AttributeValueImplTest {

	public static Date date(int year, int month, int day) {
		return new GregorianCalendar(year,month-1,day).getTime();
	}
	
	private Period period;
	
	@Before
	public void setUp() {
		period = new Period();
		period.setFrom(date(2012,1,1));
		period.setTo(date(2013,1,1));
	}
	
	@Test
	public void deductionTest() {
		assertEquals(366, period.getDaysBetween().intValue());
	}
	
	@Test
	public void listenerTest() {
		period.getDaysBetweenAttribute().addValueChangeListener(new PrintListener("Listener1"));
		period.getDaysBetweenAttribute().addValueChangeListener(new ConstraintEnforcer());
		period.getDaysBetweenAttribute().addValueChangeListener(new PrintListener("Listener2"));
		period.setTo(date(2012,2,1));
		period.setTo(date(2011,1,1));
	}

	public static class ConstraintEnforcer implements ValueChangeListener{

		@Override
		public boolean valueChanged(ValueChangeEvent event) {
			
			if (event.getNewValue().hasValue()) {
				int daysBetween = (Integer) event.getNewValue().getValue();
				if (daysBetween<0) {
					throw new RuntimeException("Invalid period");
				}
			}
			return true;
		}
		
	}
	
	public static class PrintListener implements ValueChangeListener{

		private String name;

		public PrintListener(String name) {
			this.name = name;
		}

		@Override
		public boolean valueChanged(ValueChangeEvent event) {
			System.out.println(name + ": DaysBetween: "+event.getOldValue().getValue() + " -> " + event.getNewValue().getValue());
			return true;
		}
		
	}
}
