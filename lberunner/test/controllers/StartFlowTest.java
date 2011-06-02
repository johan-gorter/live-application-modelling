package controllers;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import junit.framework.Assert;

import lbe.engine.Case;
import lbe.engine.CaseManager;
import lbe.engine.ChangeContext;
import lbe.engine.Navigator;
import lbe.engine.PageElement;
import lbe.engine.Session;
import lbe.engine.ChangeContext.FieldChange;
import lbe.model.flow.Flow;
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
