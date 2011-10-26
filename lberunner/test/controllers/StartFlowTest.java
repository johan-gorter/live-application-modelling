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
import lbe.model.Application;
import lbe.model.flow.Flow;
import lbe.model.flow.Page.PageRootElement;

import org.junit.Test;

import play.libs.F.Promise;
import app.carinsurancetest.CarInsuranceTestApplication;
import app.carinsurancetest.data.instance.CarinsuranceCaseInstance;
import app.carinsurancetest.flow.InsureFlow;
import app.designer.DesignerApplication;
import app.designer.data.instance.ApplicationInstance;

public class StartFlowTest {

	private Application application;
	private Case c;
	private PageRootElement page;
	private String username = "user";
	
	@Test
	public void testCarInsurance() throws Exception {
		application = CarInsuranceTestApplication.INSTANCE;
		c = CaseManager.create(new CarinsuranceCaseInstance());

		startFlow();
		PageCoordinates pageCoordinates = getPageCoordinates();
	
		PageElement dateOfBirth = getDateOfBirth(page);
//		Assert.assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), dateOfBirth.value);
		
		FieldChange change = new ChangeContext.FieldChange(dateOfBirth.id, "1/1/1970");

		submit(null, change);
		
		Promise<PageElement> promise2 = c.waitForChange(0, application, pageCoordinates, "user1", "user");
		
		page = (PageRootElement)promise2.get();
		dateOfBirth = getDateOfBirth(page);
		Assert.assertEquals(new GregorianCalendar(1970, 0, 1).getTime(), dateOfBirth.value);
	}

	private PageElement getDateOfBirth(PageElement pageElement) {
		return pageElement.content[0].content[0];
	}
	
	@Test
	public void testDesigner() throws Exception {
		application = DesignerApplication.INSTANCE;
		c = CaseManager.create(new ApplicationInstance());
		
		username = "bob";
		startFlow();
		PageCoordinates pageCoordinates = getPageCoordinates();
		
		PageElement toolboxButton = getToolboxButton(page);
		
		Promise<PageElement> promise = c.waitForChange(0, application, pageCoordinates, "bob1", "bob");
		c.submit(application, pageCoordinates, "bob1", "bob", new FieldChange[0], toolboxButton.id);
		Assert.assertTrue(promise.isDone());
		page = (PageRootElement)promise.get();
		Assert.assertEquals("Welcome", page.name);
	}

	@Test
	public void testDesignCarinsurance() throws Exception {
		application = DesignerApplication.INSTANCE;
		c = CaseManager.getCase("carinsurance", ApplicationInstance.class);
		
		startFlow();
		
		String id = findButtonWithTrigger(page, "flowDetails").id;
		submit(id);
		Assert.assertEquals("Flow", page.name);
		id = findButtonWithTrigger(page, "exploreInstance").id;
		submit(id);
		Assert.assertEquals("Instance", page.name);
	}
	
	// Helper functions
	
	private void startFlow()
	{
		page = (PageRootElement)c.renderOrStartFlow(application, null, username+"1", username);
	}
	
	private void submit(String id, FieldChange... changes) throws Exception {
		PageCoordinates pageCoordinates = getPageCoordinates();
		Promise<PageElement> promise = c.waitForChange(page.caseVersion, application, pageCoordinates, username+"1", username);
		c.submit(application, pageCoordinates, username+"1", username, changes, id);
		Assert.assertTrue(promise.isDone());
		page = (PageRootElement)promise.get();
	}

	private PageElement findButtonWithTrigger(PageElement pageElement, String trigger) {
		if ("button".equals(pageElement.elementType)) {
			if (trigger.equals(pageElement.name)) {
				return pageElement;
			}
		} else if (pageElement.content!=null){
			for (PageElement child: pageElement.content) {
				PageElement result = findButtonWithTrigger(child, trigger);
				if (result!=null) return result;
			}
		}
		return null;
	}

	private PageCoordinates getPageCoordinates() {
		return PageCoordinates.parse(page.id);
	}

	private PageElement getToolboxButton(PageElement pageElement) {
		return pageElement.content[0].content[1];
	}
}
