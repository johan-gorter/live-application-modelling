package org.instantlogic.fabric.util;


public interface ValueChangeObserver {
	
	/**
	 * Listener interface for value changes
	 * 
	 * @param The event.
	 * @return if the listener must be maintained. (return true to keep listening, false removes the listener)
	 */
	public void valueChanged(ValueChangeEvent event);
	
}
