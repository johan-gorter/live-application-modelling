package lbe.instance;

import java.util.ArrayList;
import java.util.HashSet;

import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;

public class Observations implements ValueChangeListener {

	private boolean outdated = false;;
	
	private HashSet<ReadOnlyAttributeValue<? extends Instance, ? extends Object>> valuesObserved 
		= new HashSet<ReadOnlyAttributeValue<? extends Instance,? extends Object>>();

	private ValueChangeListener outdatedListener;
	
	public void add(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
		if (valuesObserved.add(attributeValueObserved)) {
			attributeValueObserved.addOneTimeValueChangeListener(this);
		}
	}

	public int size() {
		return valuesObserved.size();
	}

	@Override
	public void valueChanged(ReadOnlyAttributeValue value) {
		if (!outdated) {
			outdated = true;
			for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.valuesObserved) {
				valueObserved.removeOneTimeValueChangeListener(this);
			}
			if (outdatedListener!=null) {
				outdatedListener.valueChanged(value);
			}
		}
	}
	
	public void setOneTimeOutdatedListener(ValueChangeListener listener) {
		this.outdatedListener = listener;
	}

	public void removeOneTimeOutdatedListener() {
		for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.valuesObserved) {
			valueObserved.removeOneTimeValueChangeListener(this);
		}
		outdatedListener = null;
	}

	public boolean isOutdated() {
		return outdated;
	}
}
