package lbe.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lbe.deduction.Deduction;
import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.page.PageElement.Domain;
import lbe.page.RenderContext;

public abstract class Attribute<I extends Instance, Value extends Object> extends Deduction<Value> {

	public abstract Entity getEntity();
	
	public abstract Class<Value> getDatatype();

	public abstract Text getQuestion();

	public Text getExplain() {
		return null;
	}

	public boolean isMultivalue() {
		return false;
	}

	public boolean isReadOnly() {
		return false;
	}

	public DomainEntry[] getDomain() {
		return null;
	}
	
	public Deduction<Value> getDeduction() {
		return null;
	}
	
	public Value calculateValue(I instance) {
		Deduction<Value> deduction = getDeduction();
		if (deduction!=null) {
			return deduction.deduct(instance);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Value deduct(Instance forInstance) {
		return get((I)forInstance).get();
	}
	
	public abstract AttributeValue<I, Value> get(I instance);

	private static final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("dd/MM/yyyy");
	
	public Object parse(Object value) {
		if (getDatatype()==Date.class && value instanceof String) {
			try {
				return DATE_INTERNATIONAL.parseObject((String)value);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return value;
	}

}
