package org.instantlogic.designer.flow.flow;

public class PageSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final PageSubFlow INSTANCE = new PageSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.PageFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Page";
	}
}
