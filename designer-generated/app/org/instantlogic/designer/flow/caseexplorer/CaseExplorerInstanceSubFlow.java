package org.instantlogic.designer.flow.caseexplorer;

public class CaseExplorerInstanceSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final CaseExplorerInstanceSubFlow INSTANCE = new CaseExplorerInstanceSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.CaseExplorerInstanceFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "CaseExplorerInstance";
	}
}
