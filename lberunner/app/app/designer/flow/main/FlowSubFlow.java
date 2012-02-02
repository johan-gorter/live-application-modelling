package app.designer.flow.main;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.FlowFlow;

public class FlowSubFlow extends SubFlow {

	public static final FlowSubFlow INSTANCE = new FlowSubFlow();
	
	@Override
	public Flow getFlow() {
		return FlowFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Flow";
	}
}
