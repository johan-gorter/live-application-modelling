package org.instantlogic.core.util;


public interface ValueChangeListener {
	
	/**
	 * Listener interface for value changes
	 * 
	 * @param The event.
	 * @return if the listener must be maintained. (return true to keep listening, false removes the listener)
	 */
	public boolean valueChanged(ValueChangeEvent event);
	
}
