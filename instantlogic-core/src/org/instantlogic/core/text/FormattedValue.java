package org.instantlogic.core.text;

import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.util.DeductionContext;

public class FormattedValue extends StringProducer {

	private Deduction<? extends Object> deduction;

	// TODO: formatter string

	public FormattedValue(Deduction<? extends Object> deduction) {
		this.deduction = deduction;
	}
	
	@Override
	String getValue(DeductionContext context) {
		Object result =  deduction.deduct(context);
		if (result==null) return "";
		return ""+result;
	}
}
