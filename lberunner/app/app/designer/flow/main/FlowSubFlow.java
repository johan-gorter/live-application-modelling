package app.designer.flow.main;

import app.designer.flow.*;
import lbe.model.flow.*;

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
