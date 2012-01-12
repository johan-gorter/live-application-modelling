package lbe.instance.value.impl;

import java.util.ArrayList;

import lbe.engine.SingleInstanceDeductionContext;
import lbe.instance.Instance;
import lbe.instance.Observations;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ValueChangeListener;
import lbe.model.Attribute;
import lbe.model.deduction.Deduction;

public class ReadOnlyAttributeValueImpl<I extends Instance, V extends Object> implements ReadOnlyAttributeValue<I, V> {

	public enum ValueDetermination {RELEVANCE, RULE, STORED, DEFAULT, NONE}
	
	protected final Attribute<I, V, ? extends Object> model;
	protected final I forInstance;
	
	private transient ArrayList<ValueChangeListener> oneTimeListeners = new ArrayList<ValueChangeListener>(); 
	
	private transient V cachedValue;
	protected transient Observations basedOn;
	
	protected transient AttributeValueDeduction<I, V> valueDeduction = new AttributeValueDeduction<I, V>(this);
	
	private ValueChangeListener valueChangeListener = new ValueChangeListener() {

		@Override
		public void valueChanged(ReadOnlyAttributeValue valueHolder) {
			basedOn = null;
			cachedValue = null;
			fireValueChanged();
		}
	};
	
	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, V, ? extends Object> model) {
		this.forInstance = forInstance;
		this.model = model;
	}
	
	public Attribute<I, V, ? extends Object> getModel() {
		return model;
	}
	
	public V get() {
		forInstance.getCase().registerObservation(this);
		if (cachedValue==null) {
			forInstance.getCase().startRecordingObservations();
			cachedValue = calculateValue();
			Observations observations = forInstance.getCase().stopRecordingObservations();
			if (observations.size()>0) {
				basedOn = observations;
				observations.setOneTimeOutdatedListener(valueChangeListener);
			}
		}
		return cachedValue;
	}

	// The logic for determining the value
	private V calculateValue() {
		Attribute<I, V, ? extends Object> attribute = getModel();
		SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(forInstance);
		//Relevance
		Deduction<Boolean> relevance = attribute.getRelevance();
		if (relevance!=null) {
			if (relevance.deduct(context)!=Boolean.TRUE) {
				return null;
			}
		}
		//Rule
		Deduction<V> ruleDeduction = attribute.getRule();
		if (ruleDeduction!=null) {
			V result = ruleDeduction.deduct(context);
			if (result!=null) return result;
		}
		//Stored value
		if (getStoredValue()!=null) {
			return getStoredValue();
		}
		//Default
		Deduction<V> defaultDeduction = attribute.getDefault();
		if (defaultDeduction!=null) {
			return defaultDeduction.deduct(context);
		}
		//Nothing
		return null;
	}

	protected void fireValueChanged() {
		ArrayList<ValueChangeListener> listeners = oneTimeListeners;
		oneTimeListeners = new ArrayList<ValueChangeListener>();
		for (ValueChangeListener listener: listeners) {
			listener.valueChanged(this);
		}
	}
	
	protected V getStoredValue() {
		return null;
	}

	@Override
	public void addOneTimeValueChangeListener(ValueChangeListener listener) {
		oneTimeListeners.add(listener);
	}

	@Override
	public void removeOneTimeValueChangeListener(ValueChangeListener listener) {
		oneTimeListeners.remove(listener);
	}
	
	
	
	@Override
	public String toString() {
		return this.forInstance.toString()+"."+this.model.toString();
	}
	
	@Override
	public int hashCode() {
		return new Long(forInstance.getInstanceId()).hashCode()+model.getName().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other==null || other.getClass()!=getClass()) return false;
		ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object> o = 
			(ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object>) other;
		return (o.forInstance==forInstance && o.model==model);
	}
}
