package app.designer.flow.page;

import app.designer.flow.*;
import lbe.model.flow.*;

public class AddFieldSubFlow extends SubFlow {

	public static final AddFieldSubFlow INSTANCE = new AddFieldSubFlow();
	
	@Override
	public Flow getFlow() {
		return AddFieldFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "AddField";
	}
}
