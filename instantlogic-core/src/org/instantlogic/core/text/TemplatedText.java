package org.instantlogic.core.text;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.util.DeductionContext;

public class TemplatedText extends Text {

	private List<StringProducer> stringProducers = new ArrayList<StringProducer>();
	
	public TemplatedText add(String text) {
		stringProducers.add(new ConstantString(text));
		return this;
	}
	
	public TemplatedText add(Deduction<? extends Object> value) {
		stringProducers.add(new FormattedValue(value));
		return this;
	}
	
	@Override
	public String renderText(DeductionContext context) {
		StringBuilder sb = new StringBuilder();
		for (StringProducer sp: stringProducers) {
			sb.append(sp.getValue(context));
		}
		return sb.toString();
	}

}
