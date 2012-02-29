package lbe.model.pageelement.impl;

import lbe.engine.RenderContext;

public class ConstantString extends StringProducer {

	private final String value;
	
	public ConstantString(String value) {
		this.value = value;
	}

	@Override
	String getValue(RenderContext context) {
		return value;
	}
}
