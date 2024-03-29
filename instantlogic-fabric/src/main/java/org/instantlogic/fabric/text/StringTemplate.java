package org.instantlogic.fabric.text;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class StringTemplate {

	private final Deduction<? extends Object> deduction;
	
	private final String constant;

	// TODO: make room for another constructor which accepts a formatter string and a deduction

	public StringTemplate(Deduction<? extends Object> deduction) {
		this.deduction = deduction;
		this.constant = null;
	}

	public StringTemplate(String constant) {
		this.deduction = null;
		this.constant = constant;
	}
	
	String render(DeductionContext context) {
		if (constant!=null) {
			return constant;
		}
		ValueAndLevel<?> result =  deduction.deduct(context);
		if (result.hasValue()) {
			return result.getValue().toString();
		}
		return "";
	}
}
