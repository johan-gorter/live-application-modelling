package app.designer.flow.flow;

import app.designer.flow.*;
import lbe.model.flow.*;

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
