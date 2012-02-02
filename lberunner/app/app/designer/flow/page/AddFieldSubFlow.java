package app.designer.flow.page;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.AddFieldFlow;

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
