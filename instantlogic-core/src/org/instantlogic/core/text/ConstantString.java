package org.instantlogic.core.text;

import org.instantlogic.core.util.DeductionContext;

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
