package app.designer.flow.flow;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.PageFlow;

public class PageSubFlow extends SubFlow {

	public static final PageSubFlow INSTANCE = new PageSubFlow();
	
	@Override
	public Flow getFlow() {
		return PageFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Page";
	}
}
