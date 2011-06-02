package lbe.instance.value.impl;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.model.Attribute;

public class ReadOnlyAttributeValueImpl<I extends Instance, V extends Object> implements ReadOnlyAttributeValue<I, V> {

	protected final Attribute<I, V> model;
	protected final I forInstance;
	
	private transient V calculatedValue;

	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, V> model) {
		this.forInstance = forInstance;
		this.model = model;
	}

	public Attribute<I, V> getModel() {
		return model;
	}
	
	public V get() {
		if (calculatedValue==null) {
			calculatedValue = (V)model.calculateValue(forInstance);
		}
		return calculatedValue;
	}

}
