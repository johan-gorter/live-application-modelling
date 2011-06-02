package lbe.engine;

import lbe.model.flow.Flow;
import lbe.model.flow.Interaction;
import lbe.model.flow.Page;

public class Session {

	private String caseId;
	
	private Flow startFlow;
	
	private Page currentPage;

	public static Session parse(String formattedSession, Interaction interactionModel) {
		Session result = new Session();
		String[] split = formattedSession.split("@");
		if (split.length!=3) throw new RuntimeException("Invalid session string");
		Flow startFlow = interactionModel.getExposedFlow(split[0]);
		result.setStartFlow(startFlow);
		result.setCurrentPage(startFlow.getPage(split[1]));
		result.setCaseId(split[2]);
		return result;
	}

	public String format() {
		return startFlow.getName()+"@"+currentPage.getName()+"@"+caseId;//TODO: subflows
	}
	
	public Page getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Page currentPage) {
		this.currentPage = currentPage;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public Flow getStartFlow() {
		return startFlow;
	}

	public void setStartFlow(Flow startFlow) {
		this.startFlow = startFlow;
	}
	
}
