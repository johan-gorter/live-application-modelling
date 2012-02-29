package lbe.model.pageelement.impl;

import lbe.engine.RenderContext;
import lbe.model.deduction.Deduction;

public class FormattedValue extends StringProducer {

	private Deduction<? extends Object> deduction;

	// TODO: formatter string

	public FormattedValue(Deduction<? extends Object> deduction) {
		this.deduction = deduction;
	}
	
	@Override
	String getValue(RenderContext context) {
		Object result =  deduction.deduct(context);
		if (result==null) return "";
		return ""+result;
	}
}
