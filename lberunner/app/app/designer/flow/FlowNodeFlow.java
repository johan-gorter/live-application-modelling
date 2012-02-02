package app.designer.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.designer.entity.FlowNodeBaseDesignEntity;

public class FlowNodeFlow extends Flow {

	public static final FlowNodeFlow INSTANCE = new custom.designer.FlowNodeFlowCustomization();
	
	protected FlowNodeFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
		FlowNodeBaseDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "FlowNode";
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
