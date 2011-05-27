package lbe.instance;

import lbe.model.AttributeModel;

public class AttributeValue<I extends Instance, V extends Object> {
	
	private final AttributeModel<I, V> model;
	private final I forInstance;
	
	private V storedValue;
	
	private transient V calculatedValue;


	public AttributeValue(I forInstance, AttributeModel<I, V> model) {
		this.forInstance = forInstance;
		this.model = model;
	}

	public AttributeModel<I, V> getModel() {
		return model;
	}
	
	public V get() {
		if (storedValue!=null) {
			return storedValue;
		}
		if (calculatedValue==null) {
			calculatedValue = (V)model.calculateValue(forInstance);
		}
		return calculatedValue;
	}

	public void set(V value) {
		storedValue = value;
	}
}
