package lbe.instance;

import java.util.ArrayList;

import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;

public class Observations implements ValueChangeListener {

	private boolean outdated = false;;
	
	private ArrayList<ReadOnlyAttributeValue<? extends Instance, ? extends Object>> valuesObserved 
		= new ArrayList<ReadOnlyAttributeValue<? extends Instance,? extends Object>>();

	private ValueChangeListener outdatedListener;
	
	public void add(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
		valuesObserved.add(attributeValueObserved);
	}

	public int size() {
		return valuesObserved.size();
	}

	@Override
	public void valueChanged(ReadOnlyAttributeValue value) {
		if (!outdated) {
			outdated = true;
			outdatedListener.valueChanged(value);
			for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.valuesObserved) {
				valueObserved.removeOneTimeValueChangeListener(this);
			}
		}
	}
	
	public void setOneTimeOutdatedListener(ValueChangeListener listener) {
		for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.valuesObserved) {
			valueObserved.addOneTimeValueChangeListener(this);
		}
		this.outdatedListener = listener;
	}

	public void removeOneTimeOutdatedListener() {
		outdated = true;
		for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.valuesObserved) {
			valueObserved.removeOneTimeValueChangeListener(this);
		}
		outdatedListener = null;
	}
}
