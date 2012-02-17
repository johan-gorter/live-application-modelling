package app.designer.flow.main;

import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.SubFlow;

import app.designer.flow.EntityFlow;

public class EntitySubFlow extends SubFlow {

	public static final EntitySubFlow INSTANCE = new EntitySubFlow();
	
	@Override
	public Flow getFlow() {
		return EntityFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Entity";
	}
}
