package org.instantlogic.fabric.model;

import org.instantlogic.fabric.text.TextTemplate;

public class DomainEntry {

	private final String value;
	private final TextTemplate display;
	
	public DomainEntry(String value, TextTemplate display) {
		this.value = value;
		this.display = display;
	}

	public String getValue() {
		return value;
	}

	public TextTemplate getDisplay() {
		return display;
	}
}
