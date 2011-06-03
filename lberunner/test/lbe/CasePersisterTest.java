package lbe;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import app.carinsurance.entity.CarinsuranceCaseInstance;

import lbe.engine.CasePersister;

public class CasePersisterTest {

	@Test
	public void test() {
		CarinsuranceCaseInstance caseInstance = new CarinsuranceCaseInstance();
		caseInstance.driver.get().dateOfBirth.set(new Date());
		caseInstance.driver.get().yearsDriverslicense.set(100);
		
		CasePersister.INSTANCE.persist("unittest", caseInstance);
		
		CarinsuranceCaseInstance loadedCase = CasePersister.INSTANCE.load("unittest", CarinsuranceCaseInstance.class);
		
		assertEquals((Integer)100, loadedCase.driver.get().yearsDriverslicense.get());
	}
}
