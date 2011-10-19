package app.designer.flow.caseexplorer;

import app.designer.flow.*;
import lbe.model.flow.*;

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
