package lbe;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import lbe.engine.CasePersister;

import org.junit.Test;

import app.carinsurance.CarinsuranceCase;

public class CasePersisterTest {

	@Test
	public void test() {
		CarinsuranceCase caseInstance = new CarinsuranceCase();
		caseInstance.driver.get().dateOfBirth.set(new Date());
		caseInstance.driver.get().yearsDriverslicense.set(100);
		
		CasePersister.INSTANCE.persist("unittest", caseInstance, 101);
		
		CarinsuranceCase loadedCase = CasePersister.INSTANCE.load("unittest", CarinsuranceCase.class);
		
		assertEquals((Integer)100, loadedCase.driver.get().yearsDriverslicense.get());
		assertEquals(101, loadedCase.getVersion());
	}
}
