package org.instantlogic.core.util;

import java.util.HashSet;

import org.instantlogic.core.Instance;
import org.instantlogic.core.value.ReadOnlyAttributeValue;


public class Observations implements ValueChangeListener {

	private boolean outdated = false;
	
	private HashSet<ReadOnlyAttributeValue<? extends Instance<?>, ? extends Object>> valuesObserved 
		= new HashSet<ReadOnlyAttributeValue<? extends Instance<?>,? extends Object>>();

	private ValueChangeListener outdatedListener;
	
	public void add(ReadOnlyAttributeValue<? extends Instance<?>, ? extends Object> attributeValueObserved) {
		if (valuesObserved.add(attributeValueObserved)) {
			attributeValueObserved.addValueChangeListener(this);
		}
	}

	public int size() {
		return valuesObserved.size();
	}

	@Override
	public boolean valueChanged(ValueChangeEvent value) {
		if (!outdated) {
			outdated = true;
			for (ReadOnlyAttributeValue<? extends Instance<?>,? extends Object> valueObserved: this.valuesObserved) {
				valueObserved.removeValueChangeListener(this);
			}
			if (outdatedListener!=null) {
				outdatedListener.valueChanged(value);
			}
		}
		return false;
	}
	
	public void setOneTimeOutdatedListener(ValueChangeListener listener) {
		this.outdatedListener = listener;
	}

	public void removeOneTimeOutdatedListener() {
		for (ReadOnlyAttributeValue<? extends Instance<?>,? extends Object> valueObserved: this.valuesObserved) {
			valueObserved.removeValueChangeListener(this);
		}
		outdatedListener = null;
	}

	public boolean isOutdated() {
		return outdated;
	}
}
