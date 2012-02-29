package app.designer.flow.main;

import app.designer.flow.*;
import lbe.model.flow.*;

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
