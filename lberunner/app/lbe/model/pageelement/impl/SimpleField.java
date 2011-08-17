package lbe.model.pageelement.impl;

import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.pageelement.Field;

public class SimpleField extends Field {

	private final Attribute attribute;
	private final Entity entity;
	private boolean required;
	private boolean readOnly;

	public SimpleField(Entity entity, Attribute attribute) {
		this.entity = entity;
		this.attribute = attribute;
	}

	public SimpleField setRequired() {
		this.required = true;
		return this;
	}
	
	public SimpleField setReadOnly() {
		this.readOnly = true;
		return this;
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

	@Override
	public Entity getEntity() {
		return entity;
	}
}
