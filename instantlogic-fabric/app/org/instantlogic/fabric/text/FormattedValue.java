package org.instantlogic.fabric.text;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;

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
