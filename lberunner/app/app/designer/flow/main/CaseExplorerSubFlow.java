package app.designer.flow.main;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.CaseExplorerFlow;

public class CaseExplorerSubFlow extends SubFlow {

	public static final CaseExplorerSubFlow INSTANCE = new CaseExplorerSubFlow();
	
	@Override
	public Flow getFlow() {
		return CaseExplorerFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "CaseExplorer";
	}
}
