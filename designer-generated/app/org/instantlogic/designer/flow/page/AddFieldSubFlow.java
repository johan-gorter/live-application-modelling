package org.instantlogic.designer.flow.page;

public class AddFieldSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final AddFieldSubFlow INSTANCE = new AddFieldSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.AddFieldFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "AddField";
	}
}
