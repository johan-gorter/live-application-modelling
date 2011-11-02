package lbe;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import lbe.engine.CasePersister;

import org.junit.Test;

import app.carinsurance.data.instance.CarinsuranceCaseInstance;

public class CasePersisterTest {

	@Test
	public void test() {
		CarinsuranceCaseInstance caseInstance = new CarinsuranceCaseInstance();
		caseInstance.driver.get().dateOfBirth.set(new Date());
		caseInstance.driver.get().yearsDriverslicense.set(100);
		
		CasePersister.INSTANCE.persist("unittest", caseInstance, 101);
		
		CarinsuranceCaseInstance loadedCase = CasePersister.INSTANCE.load("unittest", CarinsuranceCaseInstance.class);
		
		assertEquals((Integer)100, loadedCase.driver.get().yearsDriverslicense.get());
		assertEquals(101, loadedCase.getVersion());
	}
}
