package controllers;

import org.apache.log4j.Logger;

import lbe.Case;
import lbe.CaseManager;
import lbe.Session;
import lbe.flow.Navigator;
import lbe.model.FlowModel;
import lbe.model.InteractionModel;
import lbe.page.Page;
import lbe.page.PageElement;
import lbe.page.PageRenderer;
import lbemodel.CarinsuranceInteractionModel;
import play.mvc.Controller;

public class StartFlow extends Controller {

	private static final Logger LOG = Logger.getLogger(StartFlow.class);
	
	private static final InteractionModel application = CarinsuranceInteractionModel.INSTANCE;
	
	public static void index(String caseId, String startFlowName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("index("+caseId+", "+startFlowName+")");
		}
		CaseManager.fireChangesIfModelChanged();
		Case c;
		if (caseId==null) {
			c = CaseManager.create();
		} else {
			c = CaseManager.getCase(caseId);
		}
		FlowModel startFlow;
		if (startFlowName==null) {
			startFlow = application.getExposedFlows()[0];
		} else {
			startFlow = application.getExposedFlow(startFlowName);
		}
		Session lbeSession = Navigator.startFlow(c, startFlow);
		redirect("StartFlow.continueSession", lbeSession.format());
	}
	
	public static void continueSession(String formattedSession) {
		renderArgs.put("formattedSession", formattedSession);
		render();
	}
	
	public static void getFirstPage(String formattedSession) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getFirstPage("+formattedSession+")");
		}
		CaseManager.fireChangesIfModelChanged();
		
		Session lbesession = Session.parse(formattedSession, application);
		Case c = CaseManager.getCase(lbesession.getCaseId());
		renderJSON(c.render(lbesession));
	}

	public static void waitForPageChange(String formattedSession, int lastCaseVersion) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("waitForPageChange("+formattedSession+", "+lastCaseVersion+")");
		}
		CaseManager.fireChangesIfModelChanged();
		
		Session lbesession = Session.parse(formattedSession, application);
		Case c = CaseManager.getCase(lbesession.getCaseId());
		Page page = await(c.waitForChange(lastCaseVersion, lbesession));
		renderJSON(page);
	}
}
