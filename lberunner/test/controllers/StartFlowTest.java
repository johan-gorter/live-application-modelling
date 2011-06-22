package controllers;

import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

import junit.framework.Assert;
import lbe.engine.Case;
import lbe.engine.CaseManager;
import lbe.engine.ChangeContext;
import lbe.engine.ChangeContext.FieldChange;
import lbe.engine.PageCoordinates;
import lbe.engine.PageElement;
import lbe.model.flow.Flow;

import org.junit.Test;

import play.libs.F.Promise;
import app.carinsurancetest.CarInsuranceTestApplication;
import app.carinsurancetest.data.instance.CarinsuranceCaseInstance;
import app.carinsurancetest.flow.InsureFlow;

public class StartFlowTest {

	@Test
	public void testGetFirstPage() throws InterruptedException, ExecutionException {
		Flow flowModel = CarInsuranceTestApplication.INSTANCE.getExposedFlows()[0];
		Case c = CaseManager.create(new CarinsuranceCaseInstance());

		PageElement pageElement = c.startFlow(InsureFlow.INSTANCE);
		PageCoordinates pageCoordinates = PageCoordinates.parse(pageElement.id);
	
		PageElement dateOfBirth = getDateOfBirth(pageElement);
//		Assert.assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), dateOfBirth.value);
		
		FieldChange change = new ChangeContext.FieldChange(dateOfBirth.id, "1/1/1970");

		Promise<PageElement> promise1 = c.waitForChange(0, InsureFlow.INSTANCE, pageCoordinates);
		Assert.assertFalse(promise1.isDone());
		c.submit(InsureFlow.INSTANCE, pageCoordinates, new FieldChange[]{change}, null);
		Assert.assertTrue(promise1.isDone());
		
		Promise<PageElement> promise2 = c.waitForChange(0, InsureFlow.INSTANCE, pageCoordinates);
		
		pageElement = promise2.get();
		dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1970, 0, 1).getTime(), dateOfBirth.value);
	}

	private PageElement getDateOfBirth(PageElement pageElement) {
		return pageElement.content[0].content[0];
	}
}
