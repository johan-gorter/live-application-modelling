package app.designer.flow.flow;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.FlowNodeFlow;

public class FlowNodeSubFlow extends SubFlow {

	public static final FlowNodeSubFlow INSTANCE = new FlowNodeSubFlow();
	
	@Override
	public Flow getFlow() {
		return FlowNodeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "FlowNode";
	}
}
