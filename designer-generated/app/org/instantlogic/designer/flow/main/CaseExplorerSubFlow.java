package org.instantlogic.designer.flow.main;

public class CaseExplorerSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final CaseExplorerSubFlow INSTANCE = new CaseExplorerSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.CaseExplorerFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "CaseExplorer";
	}
}
