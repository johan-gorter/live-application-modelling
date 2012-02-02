package app.designer.flow.caseexplorer;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.CaseExplorerInstanceFlow;

public class CaseExplorerInstanceSubFlow extends SubFlow {

	public static final CaseExplorerInstanceSubFlow INSTANCE = new CaseExplorerInstanceSubFlow();
	
	@Override
	public Flow getFlow() {
		return CaseExplorerInstanceFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "CaseExplorerInstance";
	}
}
