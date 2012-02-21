package org.instantlogic.fabric.text;

import org.instantlogic.fabric.util.DeductionContext;

public class ConstantString extends StringProducer {

	private final String value;
	
	public ConstantString(String value) {
		this.value = value;
	}

	@Override
	String getValue(DeductionContext context) {
		return value;
	}
}
