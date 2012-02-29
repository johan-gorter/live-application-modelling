package lbe.instance.value.impl;

import lbe.engine.DeductionContext;
import lbe.engine.SingleInstanceDeductionContext;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.deduction.Deduction;

/**
 * Contains the logic for deriving an attribute's value. For internal use.
 */
class AttributeValueDeduction<I extends Instance, V> {
	
	private ReadOnlyAttributeValueImpl<I, V> attributeValue;
	
	private V cachedValue;
	
	AttributeValueDeduction(ReadOnlyAttributeValueImpl<I, V> attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	void storedValueChanged() {
		
	}
	
	
	public V getCachedValue() {
		return cachedValue;
	}
	
}
