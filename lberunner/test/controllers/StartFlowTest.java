package controllers;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import junit.framework.Assert;

import lbe.Case;
import lbe.CaseManager;
import lbe.Session;
import lbe.flow.Navigator;
import lbe.model.FlowModel;
import lbe.page.PageElement;
import lbemodel.CarinsuranceInteractionModel;
import lbemodel.entity.CarinsuranceCaseInstance;

import org.junit.Test;

public class StartFlowTest {

	@Test
	public void testGetFirstPage() {
		FlowModel flowModel = CarinsuranceInteractionModel.INSTANCE.getExposedFlows()[0];
		Case caseInstance = CaseManager.create(new CarinsuranceCaseInstance());
		Session session = Navigator.startFlow(caseInstance, flowModel);
		
		PageElement pageElement = caseInstance.render(session);
	
		PageElement dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), dateOfBirth.value);
		
		caseInstance.changeValue(session, dateOfBirth.id, new GregorianCalendar(1970, 0, 1).getTime());
		
		pageElement = caseInstance.render(session);
		dateOfBirth = getDateOfBirth(pageElement);
		Assert.assertEquals(new GregorianCalendar(1970, 0, 1).getTime(), dateOfBirth.value);
	}

	private PageElement getDateOfBirth(PageElement pageElement) {
		return pageElement.content[0].content[0];
	}

}
