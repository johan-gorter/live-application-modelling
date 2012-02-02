package org.instantlogic.core.util;

import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyAttributeValues;

public class ValueChangeEvent {

	public enum MultiValueUpdateType {INSERT, DELETE}
	
	private final ValueAndLevel<? extends Object> oldValue;
	private final ReadOnlyAttributeValue<?,?> attributeValue;
	private Object oldStoredValue;
	private Object newStoredValue;
	// For multivalue updates
	private MultiValueUpdateType multiValueUpdateType;
	private int index;
	private Object itemValue;
	
	// For single value attributes/relations and invalidations of multivalue attributes/relations
	public ValueChangeEvent(ReadOnlyAttributeValue<?,?> attributeValue, ValueAndLevel<? extends Object> oldValue, Object oldStoredValue, Object newStoredValue) {
		this.attributeValue = attributeValue;
		this.oldValue = oldValue;
		this.oldStoredValue = oldStoredValue;
		this.newStoredValue = newStoredValue;
	}
	
	// For updates on multivalue attributes/relations
	public ValueChangeEvent(ReadOnlyAttributeValues<?,?> attributeValue, ValueAndLevel<? extends Object> value, MultiValueUpdateType multiValueUpdateType, int index, Object itemValue) {
		this.attributeValue = attributeValue;
		this.oldValue = value;
		this.multiValueUpdateType = multiValueUpdateType;
		this.index = index;
		this.itemValue = itemValue;
	}
	
	/**
	 * @return The attribute/relation is multivalue and the value only got updated. (not invalidated)
	 */
	public boolean isMultivalueUpdate() {
		return multiValueUpdateType!=null;
	}
	
	
	public Attribute<?, ?, ?> getAttribute() {
		return attributeValue.getModel();
	}
	
	public Instance<?> getInstance() {
		return attributeValue.getInstance();
	}
	
	/**
	 * @return The previous value, if it was ever deduced. (It usually is, because listening for updates on a value that you never retrieved is not very useful) 
	 */
	public ValueAndLevel<? extends Object> getOldValue() {
		return oldValue;
	}
	
	/**
	 * Use with caution, calling getNewValue can cause loops and inefficiencies.
	 * 
	 * @param deduceIfNecessary
	 * @return
	 */
	public ValueAndLevel<? extends Object> getNewValue() {
		return attributeValue.getValueAndLevel();
	}

	public Object getNewStoredValue() {
		return newStoredValue;
	}

	public Object getOldStoredValue() {
		return oldStoredValue;
	}
	
	public boolean storedValueChanged() {
		return newStoredValue!=oldStoredValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValueChangeEvent [attributeValue=")
				.append(attributeValue).append(", oldValue=").append(oldValue)
				.append(", oldStoredValue=").append(oldStoredValue)
				.append(", newStoredValue=").append(newStoredValue)
				.append(", multiValueUpdateType=").append(multiValueUpdateType)
				.append(", index=").append(index).append(", itemValue=")
				.append(itemValue).append("]");
		return builder.toString();
	}
}
