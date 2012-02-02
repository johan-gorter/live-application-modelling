package app.designer.flow.entity;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.AttributeFlow;

public class AttributeSubFlow extends SubFlow {

	public static final AttributeSubFlow INSTANCE = new AttributeSubFlow();
	
	@Override
	public Flow getFlow() {
		return AttributeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Attribute";
	}
}
