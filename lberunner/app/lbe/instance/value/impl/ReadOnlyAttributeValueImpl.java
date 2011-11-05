package lbe.instance.value.impl;

import java.util.ArrayList;

import lbe.instance.Instance;
import lbe.instance.Observations;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;
import lbe.model.Attribute;

public class ReadOnlyAttributeValueImpl<I extends Instance, V extends Object> implements ReadOnlyAttributeValue<I, V>, ValueChangeListener {

	protected final Attribute<I, V, ? extends Object> model;
	protected final I forInstance;
	
	private transient ArrayList<ValueChangeListener> oneTimeListeners = new ArrayList<ValueChangeListener>(); 
	
	private transient V calculatedValue;
	
	protected transient Observations basedOn;

	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, V, ? extends Object> model) {
		this.forInstance = forInstance;
		this.model = model;
	}

	public Attribute<I, V, ? extends Object> getModel() {
		return model;
	}
	
	public V get() {
		forInstance.getCase().registerObservation(this);
		if (calculatedValue==null) {
			forInstance.getCase().startRecordingObservations();
			calculatedValue = (V)model.calculateValue(forInstance);
			Observations observations = forInstance.getCase().stopRecordingObservations();
			if (observations.size()>0) {
				basedOn = observations;
				observations.setOneTimeOutdatedListener(this);
			}
		}
		return calculatedValue;
	}

	@Override
	public void valueChanged(ReadOnlyAttributeValue value) {
		calculatedValue = null;
		basedOn = null;
		fireValueChanged();
	}
	
	protected void fireValueChanged() {
		ArrayList<ValueChangeListener> listeners = oneTimeListeners;
		oneTimeListeners = new ArrayList<ValueChangeListener>();
		for (ValueChangeListener listener: listeners) {
			listener.valueChanged(this);
		}
	}

	@Override
	public void addOneTimeValueChangeListener(ValueChangeListener listener) {
		oneTimeListeners.add(listener);
	}

	@Override
	public void removeOneTimeValueChangeListener(ValueChangeListener listener) {
		oneTimeListeners.add(listener);
	}
}
