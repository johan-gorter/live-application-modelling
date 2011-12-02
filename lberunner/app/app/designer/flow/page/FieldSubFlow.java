package app.designer.flow.page;

import app.designer.flow.*;
import lbe.model.flow.*;

public class FieldSubFlow extends SubFlow {

	public static final FieldSubFlow INSTANCE = new FieldSubFlow();
	
	@Override
	public Flow getFlow() {
		return FieldFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Field";
	}
}
