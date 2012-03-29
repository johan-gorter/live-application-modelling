package org.instantlogic.designer.flow.page;

public class FieldSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final FieldSubFlow INSTANCE = new FieldSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.FieldFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Field";
	}
}
