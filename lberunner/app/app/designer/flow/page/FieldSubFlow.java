package app.designer.flow.page;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.FieldFlow;

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
