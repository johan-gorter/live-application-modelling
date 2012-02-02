package org.instantlogic.core.model.impl;

import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.text.ConstantText;
import org.instantlogic.core.text.Text;


public abstract class SimpleAttribute<I extends Instance<I>, Value extends Object, Item extends Object> extends Attribute<I, Value, Item> {

	private final String name;
	private final Entity<I> entity;
	private final Class<Item> valueClass;
	private Text question = null;
	
	public SimpleAttribute(String name, Entity<I> entity, Class<Item> valueClass) {
		this.name = name;
		this.entity = entity;
		this.valueClass = valueClass;
	}

	@Override
	public Entity<I> getEntity() {
		return entity;
	}

	@Override
	public Class<Item> getDatatype() {
		return valueClass;
	}

	@Override
	public Text getQuestion() {
		if (question!=null) return question;
		return new ConstantText("["+name+"]");
	}

	@Override
	public String getName() {
		return name;
	}

	public void setQuestion(Text question) {
		this.question = question;
	}
}
