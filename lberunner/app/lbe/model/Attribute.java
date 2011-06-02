package lbe.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lbe.instance.Instance;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.deduction.Deduction;
import lbe.model.pageelement.Text;

/**
 * 
 * @author Gast
 *
 * @param <I>
 * @param <Value> Either the same as <Item> or List<Item>
 * @param <Item>
 */
public abstract class Attribute<I extends Instance, Value extends Object, Item extends Object> extends Deduction<Value> {

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
	
	public abstract AttributeValueImpl<I, Value> get(I instance);

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
