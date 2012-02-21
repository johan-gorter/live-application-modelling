package org.instantlogic.interaction.page.impl;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.page.Field;


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
