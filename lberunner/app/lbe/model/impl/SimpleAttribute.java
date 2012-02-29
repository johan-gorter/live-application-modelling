package lbe.model.impl;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;

public abstract class SimpleAttribute<I extends Instance, Value extends Object, Item extends Object> extends Attribute<I, Value, Item> {

	private final String name;
	private final Entity entity;
	private final Class<Item> valueClass;
	private final Text question = null;
	
	public SimpleAttribute(String name, Entity entity, Class<Item> valueClass) {
		this.name = name;
		this.entity = entity;
		this.valueClass = valueClass;
	}

	@Override
	public Entity getEntity() {
		return entity;
	}

	@Override
	public Class<Item> getDatatype() {
		return valueClass;
	}

	@Override
	public Text getQuestion() {
		return new ConstantText("["+name+"]");
	}

	@Override
	public String getName() {
		return name;
	}
}
