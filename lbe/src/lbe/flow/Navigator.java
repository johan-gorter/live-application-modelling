package lbe.flow;

import lbe.Case;
import lbe.Session;
import lbe.model.FlowModel;
import lbe.model.FlowNodeModelBase;
import lbe.model.PageModel;

public final class Navigator {

	private Navigator() {}
	
	public static Session startFlow(Case c, FlowModel startFlow) {
		FlowNodeModelBase node = startFlow.getStart();
		if (node instanceof PageModel) {
			Session session = new Session();
			session.setCaseId(c.getId());
			session.setStartFlow(startFlow);
			session.setCurrentPage((PageModel)node);
			return session;
		}
		throw new RuntimeException("Not yet implemented");
	}
	
	public static void continueFlow(Case c, Session session, FlowNodeModelBase node, String event) {
		throw new RuntimeException("Not yet implemented");
	}
}
