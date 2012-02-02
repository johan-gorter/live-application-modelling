package org.instantlogic.core.model;

import org.instantlogic.core.Instance;
import org.instantlogic.core.deduction.AttributeDeduction;
import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.deduction.SelectedInstanceDeduction;
import org.instantlogic.core.text.Text;
import org.instantlogic.core.value.ReadOnlyAttributeValue;

/**
 * Can be compared to a field of an Object, only more powerful.
 *  
 * @param <I>
 * @param <Value> Either the same as <Item> or List<Item>
 * @param <Item>
 */
public abstract class Attribute<I extends Instance<I>, Value extends Object, Item extends Object> extends Concept {

	public abstract Entity<I> getEntity();
	
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
	
	public Deduction<Boolean> getRelevance() {
		return null;
	}
	
	public Deduction<Value> getRule() {
		return null;
	}
	
	public Deduction<Value> getDefault() {
		return null;
	}
	
	public abstract ReadOnlyAttributeValue<I, Value> get(I instance);
	
	public AttributeDeduction<Value, I> toDeduction() {
		SelectedInstanceDeduction<I> selectedInstanceDeduction = new SelectedInstanceDeduction<I>(this.getEntity());
		return new AttributeDeduction<Value, I>((Attribute<I, Value, ? extends Object>) this, selectedInstanceDeduction);
	}
}
