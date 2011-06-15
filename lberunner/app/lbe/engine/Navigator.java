package lbe.engine;

import java.util.Map;

import lbe.model.flow.Flow;
import lbe.model.flow.FlowEdge;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.FlowSource;
import lbe.model.flow.Page;

public final class Navigator {

	private Navigator() {}
	
	public static Session startFlow(Case c, Flow startFlow) {
		FlowSource[] sources = startFlow.getSources();
		if (sources.length!=1) {
			throw new RuntimeException("Can only start a flow with exactly 1 source");
		}
		FlowNodeBase node = sources[0];
		FlowEdge edge = startFlow.getEdge(sources[0]);
		node = edge.getTo();
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
