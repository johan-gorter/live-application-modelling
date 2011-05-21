package lbe;

import lbe.model.FlowModel;
import lbe.model.InteractionModel;
import lbe.model.PageModel;

public class Session {

	private String caseId;
	
	private FlowModel startFlow;
	
	private PageModel currentPage;

	public static Session parse(String formattedSession, InteractionModel interactionModel) {
		Session result = new Session();
		String[] split = formattedSession.split("@");
		if (split.length!=3) throw new RuntimeException("Invalid session string");
		FlowModel startFlow = interactionModel.getExposedFlow(split[0]);
		result.setStartFlow(startFlow);
		result.setCurrentPage(startFlow.getPage(split[1]));
		result.setCaseId(split[2]);
		return result;
	}

	public String format() {
		return startFlow.getName()+"@"+currentPage.getName()+"@"+caseId;//TODO: subflows
	}
	
	public PageModel getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(PageModel currentPage) {
		this.currentPage = currentPage;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public FlowModel getStartFlow() {
		return startFlow;
	}

	public void setStartFlow(FlowModel startFlow) {
		this.startFlow = startFlow;
	}
	
}
