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
import app.designer.DesignerApplication;
import app.designer.data.instance.ApplicationInstance;

public class StartFlowTest {

	@Test
	public void testCarInsurance() throws InterruptedException, ExecutionException {
		CarInsuranceTestApplication application = CarInsuranceTestApplication.INSTANCE;
		Case c = CaseManager.create(new CarinsuranceCaseInstance());

		PageElement pageElement = c.renderOrStartFlow(application, null, "alice1", "alice");
		PageCoordinates pageCoordinates = getPageCoordinates(pageElement);
	
		PageElement dateOfBirth = getDateOfBirth(pageElement);
//		Assert.assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), dateOfBirth.value);
		
		FieldChange change = new ChangeContext.FieldChange(dateOfBirth.id, "1/1/1970");

		Promise<PageElement> promise1 = c.waitForChange(0, application, pageCoordinates, "alice1", "alice");
		Assert.assertFalse(promise1.isDone());
		c.submit(application, pageCoordinates, "alice1", "alice", new FieldChange[]{change}, null);
		Assert.assertTrue(promise1.isDone());
		
		Promise<PageElement> promise2 = c.waitForChange(0, application, pageCoordinates, "alice1", "alice");
		
		pageElement = promise2.get();
		dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1970, 0, 1).getTime(), dateOfBirth.value);
	}

	private PageElement getDateOfBirth(PageElement pageElement) {
		return pageElement.content[0].content[0];
	}
	
	@Test
	public void testDesigner() throws Exception {
		DesignerApplication application = DesignerApplication.INSTANCE;
		Case c = CaseManager.create(new ApplicationInstance());
		
		PageElement pageElement = c.renderOrStartFlow(application, null, "bob1", "bob");
		PageCoordinates pageCoordinates = getPageCoordinates(pageElement);
		
		PageElement toolboxButton = getToolboxButton(pageElement);
		
		Promise<PageElement> promise = c.waitForChange(0, application, pageCoordinates, "bob1", "bob");
		c.submit(application, pageCoordinates, "bob1", "bob", new FieldChange[0], toolboxButton.id);
		Assert.assertTrue(promise.isDone());
		pageElement = promise.get();
		Assert.assertEquals("PageToolbox", pageElement.name);
		
	}

	private PageCoordinates getPageCoordinates(PageElement pageElement) {
		return PageCoordinates.parse(pageElement.id);
	}

	private PageElement getToolboxButton(PageElement pageElement) {
		return pageElement.content[0].content[1];
	}
}
