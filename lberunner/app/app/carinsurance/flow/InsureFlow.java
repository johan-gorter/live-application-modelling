package app.carinsurance.flow;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.carinsurance.flow.insure.DriverPage;

public class InsureFlow extends Flow {

	public static final InsureFlow INSTANCE = new InsureFlow();
	
	protected InsureFlow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
		new FlowSource(
			null,
			DriverPage.INSTANCE,
			null
		),
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	};
	
	@Override
	public String getName() {
		return "Insure";
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
