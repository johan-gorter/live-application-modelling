package app.oldcarinsurance.flow;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.FlowSource;

import app.oldcarinsurance.flow.insure.DriverPage;

public class InsureFlow extends Flow {
	
	public static final InsureFlow INSTANCE = new InsureFlow();
	
	private static final FlowSource START = new FlowSource(null, DriverPage.INSTANCE, null);

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		DriverPage.INSTANCE
	};

	private static final FlowSource[] SOURCES = new FlowSource[]{
		START
	};

	private static final FlowEdge[] EDGES = new FlowEdge[]{
//		new FlowEdge(START, null, DriverPage.INSTANCE, null)
	};

	private static final Entity[] PARAMETERS = new Entity[0];
	
	private InsureFlow() {
	}
	
	@Override
	public String getName() {
		return "Insure";
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
	public FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public Entity[] getParameters() {
		return PARAMETERS;
	}
}
