package controllers;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import junit.framework.Assert;

import lbe.Case;
import lbe.CaseManager;
import lbe.Session;
import lbe.flow.Navigator;
import lbe.model.Flow;
import lbe.page.ChangeContext;
import lbe.page.ChangeContext.FieldChange;
import lbe.page.PageElement;
import lbemodel.CarinsuranceInteractionModel;
import lbemodel.entity.CarinsuranceCaseInstance;

import org.junit.Test;

public class StartFlowTest {

	@Test
	public void testGetFirstPage() {
		Flow flowModel = CarinsuranceInteractionModel.INSTANCE.getExposedFlows()[0];
		Case c = CaseManager.create(new CarinsuranceCaseInstance());
		Session session = Navigator.startFlow(c, flowModel);
		
		PageElement pageElement = c.render(session);
	
		PageElement dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), dateOfBirth.value);
		
		FieldChange change = new ChangeContext.FieldChange(dateOfBirth.id, "1/1/1970");
		c.submit(session, new FieldChange[]{change}, null);
		
		pageElement = c.render(session);
		dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1970, 0, 1).getTime(), dateOfBirth.value);
	}

	private PageElement getDateOfBirth(PageElement pageElement) {
		return pageElement.content[0].content[0];
	}

}
