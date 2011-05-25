package lbe.instance;

import lbe.model.AttributeModel;

public class AttributeValue<V extends Object> {
	
	private final AttributeModel<V> model;
	private final Instance forInstance;
	
	private V storedValue;
	
	private transient V calculatedValue;


	public AttributeValue(Instance forInstance, AttributeModel<V> model) {
		this.forInstance = forInstance;
		this.model = model;
	}

	public AttributeModel<V> getModel() {
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
}
