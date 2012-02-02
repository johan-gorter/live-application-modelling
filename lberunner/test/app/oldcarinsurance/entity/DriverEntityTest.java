package app.oldcarinsurance.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import app.oldcarinsurance.CarinsuranceCase;
import app.oldcarinsurance.Driver;

public class DriverEntityTest {
	
	@Test
	public void testDeductions() {
		CarinsuranceCase c = new CarinsuranceCase();
		Driver d = new Driver(c);
		assertEquals(Integer.valueOf(100), d.penalty.get());
		d.yearsInsured.set(5);
		assertEquals(Integer.valueOf(5), d.penalty.get());
	}
}
