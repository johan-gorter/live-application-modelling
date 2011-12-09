package lbe.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lbe.engine.DeductionContext;
import lbe.engine.SingleInstanceDeductionContext;
import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.deduction.AttributeDeduction;
import lbe.model.deduction.Deduction;
import lbe.model.deduction.SelectedInstanceDeduction;
import lbe.model.pageelement.Text;

/**
 * 
 * @author Gast
 *
 * @param <I>
 * @param <Value> Either the same as <Item> or List<Item>
 * @param <Item>
 */
public abstract class Attribute<I extends Instance, Value extends Object, Item extends Object> extends Model {

	public abstract Entity getEntity();
	
	public abstract Class<Item> getDatatype();

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
	
	public Deduction<Value> getDefault() {
		return null;
	}
	
	// TODO: not public
	public Value calculateValue(I instance) {
		Deduction<Value> deduction = getDefault();
		if (deduction!=null) {
			return deduction.deduct(new SingleInstanceDeductionContext(instance));
		}
		return null;
	}
	
	public abstract ReadOnlyAttributeValue<I, Value> get(I instance);

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
	
	public AttributeDeduction<Value, Instance> toDeduction() {
		SelectedInstanceDeduction<Instance> selectedInstanceDeduction = new SelectedInstanceDeduction<Instance>(this.getEntity());
		return new AttributeDeduction<Value, Instance>((Attribute<Instance, Value, ? extends Object>) this, selectedInstanceDeduction);
	}
}
