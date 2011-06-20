package lbe.model.pageelement.impl;

import lbe.model.Attribute;
import lbe.model.pageelement.Field;

public class SimpleField extends Field {

	private final Attribute attribute;
	private boolean required;
	private boolean readOnly;

	public SimpleField setRequired() {
		this.required = true;
		return this;
	}
	
	public SimpleField setReadOnly() {
		this.readOnly = true;
		return this;
	}
	
	public SimpleField(Attribute attribute) {
		this.attribute = attribute;
	}

	@Override
	public Attribute getAttribute() {
		return attribute;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public boolean isReadOnly() {
		return readOnly;
	}
}
