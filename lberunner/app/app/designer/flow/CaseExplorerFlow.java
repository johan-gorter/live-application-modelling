package app.designer.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.event.ExploreInstanceEvent;
import app.designer.flow.caseexplorer.CaseExplorerInstanceSubFlow;

public class CaseExplorerFlow extends Flow {

	public static final CaseExplorerFlow INSTANCE = new CaseExplorerFlow();
	
	protected CaseExplorerFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			ExploreInstanceEvent.INSTANCE,
			CaseExplorerInstanceSubFlow.INSTANCE,
			ExploreInstanceEvent.INSTANCE
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		CaseExplorerInstanceSubFlow.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(
			CaseExplorerInstanceSubFlow.INSTANCE, 
			ExploreInstanceEvent.INSTANCE,
			CaseExplorerInstanceSubFlow.INSTANCE,
			ExploreInstanceEvent.INSTANCE
		),
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorer";
	}

	@Override
	public FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public Entity[] getParameters() {
		return PARAMETERS;
	}
}
