package app.designer.flow;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.event.ExploreInstanceEvent;
import app.designer.flow.caseexplorerinstance.InstancePage;

public class CaseExplorerInstanceFlow extends Flow {

	public static final CaseExplorerInstanceFlow INSTANCE = new custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization();
	
	protected CaseExplorerInstanceFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			ExploreInstanceEvent.INSTANCE,
			InstancePage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		InstancePage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "CaseExplorerInstance";
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
