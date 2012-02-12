package org.instantlogic.fabric.value.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
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
	
	
	@Test()
	public void listenerTest() {
		PrintListener listener1 = new PrintListener("Listener1", period.getDaysBetween());
		PrintListener listener2 = new PrintListener("Listener2", period.getDaysBetween());
		try {
			period.getDaysBetweenAttribute().addValueChangeListener(listener1, true);
			period.getDaysBetweenAttribute().addValueChangeListener(new ConstraintEnforcer(), true);
			period.getDaysBetweenAttribute().addValueChangeListener(listener2, true);
			period.setTo(date(2012,2,1));
			assertEquals(1, listener1.getNrOfUpdates());
			assertEquals(1, listener2.getNrOfUpdates());
			assertEquals(31, listener1.getLastValue());
			assertEquals(31, listener2.getLastValue());
			period.setTo(date(2011,1,1));
			fail();
		} catch(InvalidPeriodException expected) {
			System.out.println("Exception caught");
			assertEquals(3, listener1.getNrOfUpdates());
			assertEquals(1, listener2.getNrOfUpdates());
			assertEquals(31, listener1.getLastValue());
			assertEquals(31, listener2.getLastValue());
			period.setTo(date(2012,3,1));
			assertEquals(4, listener1.getNrOfUpdates());
			assertEquals(2, listener2.getNrOfUpdates());
			assertEquals(60, listener1.getLastValue());
			assertEquals(60, listener2.getLastValue());
		}
	}

	public static class ConstraintEnforcer implements ValueChangeObserver{

		@Override
		public void valueChanged(ValueChangeEvent event) {
			
			if (event.getNewValue().hasValue()) {
				int daysBetween = (Integer) event.getNewValue().getValue();
				if (daysBetween<0) {
					throw new InvalidPeriodException();
				}
			}
		}
	}
	
	public static class InvalidPeriodException extends RuntimeException {
		
	}
	
	public static class PrintListener implements ValueChangeObserver{

		private String name;
		
		private Integer lastValue;
		
		private int nrOfUpdates;

		public PrintListener(String name, Integer lastValue) {
			this.name = name;
			this.lastValue = lastValue;
		}

		@Override
		public void valueChanged(ValueChangeEvent event) {
			assertEquals(lastValue, event.getOldValue().getValue());
			if (event.getNewValue().equals(event.getOldValue())) {
				fail();
			}
			lastValue = (Integer)event.getNewValue().getValue();
			nrOfUpdates ++;
			System.out.println(name + ": DaysBetween: "+event.getOldValue().getValue() + " -> " + event.getNewValue().getValue());
		}

		public int getLastValue() {
			return lastValue;
		}

		public int getNrOfUpdates() {
			return nrOfUpdates;
		}
	}
}
