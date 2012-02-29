package app.designer.flow.entity;

import app.designer.flow.*;
import lbe.model.flow.*;

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
