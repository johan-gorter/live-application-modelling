package lbe.instance;

import lbe.model.Attribute;

public class ReadonlyAttributeValue<I extends Instance, V extends Object> {

	protected final Attribute<I, V> model;
	protected final I forInstance;
	
	private transient V calculatedValue;

	public ReadonlyAttributeValue(I forInstance, Attribute<I, V> model) {
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
