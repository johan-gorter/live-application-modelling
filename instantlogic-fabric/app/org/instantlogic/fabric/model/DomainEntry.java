package org.instantlogic.fabric.model;

import org.instantlogic.fabric.text.Text;

public class DomainEntry {

	private final String value;
	private final Text display;
	
	public DomainEntry(String value, Text display) {
		this.value = value;
		this.display = display;
	}

	public String getValue() {
		return value;
	}

	public Text getDisplay() {
		return display;
	}
}
