package app.designer.flow.main;

import app.designer.flow.*;
import lbe.model.flow.*;

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
