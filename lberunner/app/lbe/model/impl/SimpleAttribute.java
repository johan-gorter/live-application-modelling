package lbe.model.impl;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.pageelement.Text;

public abstract class SimpleAttribute<I extends Instance, Value extends Object> extends Attribute<I, Value> {

	private final String name;
	private final Entity entity;
	private final Class<Value> valueClass;
	private Text question = null;
	
	public SimpleAttribute(String name, Entity entity, Class<Value> valueClass) {
		this.name = name;
		this.entity = entity;
		this.valueClass = valueClass;
	}

	@Override
	public Entity getEntity() {
		return entity;
	}

	@Override
	public Class<Value> getDatatype() {
		return valueClass;
	}

	@Override
	public Text getQuestion() {
		return question;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setQuestion(Text question) {
		this.question = question;
	}

}
