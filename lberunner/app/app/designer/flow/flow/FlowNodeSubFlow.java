package app.designer.flow.flow;

import app.designer.flow.*;
import lbe.model.flow.*;

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
