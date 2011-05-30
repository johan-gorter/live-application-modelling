package lbe.flow;

import java.util.Map;

import lbe.Case;
import lbe.Session;
import lbe.model.Flow;
import lbe.model.FlowNodeBase;
import lbe.model.Page;

public final class Navigator {

	private Navigator() {}
	
	public static Session startFlow(Case c, Flow startFlow) {
		FlowNodeBase node = startFlow.getStart();
		if (node instanceof Page) {
			Session session = new Session();
			session.setCaseId(c.getId());
			session.setStartFlow(startFlow);
			session.setCurrentPage((Page)node);
			return session;
		}
		throw new RuntimeException("Not yet implemented");
	}

	public static void handleEvent(Case c, Session session, FlowNodeBase node, String pageElementId) {
		throw new RuntimeException("Not yet implemented");
	}
}
