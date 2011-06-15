package lbe.model.impl;

import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.instance.value.impl.ReverseRelationValueImpl;
import lbe.instance.value.impl.ReverseRelationValuesImpl;
import lbe.model.Entity;
import lbe.model.Relation;

public abstract class SimpleRelation<I extends Instance, Value extends Object, To extends Instance> extends Relation<I, Value, To> {

	private final String name;
	private final Entity entity;
	private final Entity to;
	private final Class<To> valueClass;
	private Relation<To, ? extends Object,I> reverseRelation;
	
	
	public SimpleRelation(String name, Entity entity, Entity to,
			Class<To> valueClass, Relation<To, ? extends Object,I> reverseRelation) {
		this.name = name;
		this.entity = entity;
		this.to = to;
		this.valueClass = valueClass;
		this.reverseRelation = reverseRelation;
		if (reverseRelation!=null) {
			reverseRelation.setReverseRelation(this);
		}
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Entity getTo() {
		return to;
	}

	@Override
	public boolean isOwner() {
		return false;
	}

	@Override
	public boolean isMultivalue() {
		return false;
	}
	
	@Override
	public boolean isReverse() {
		return false;
	}
	
	/* Needed for bootstrapping */
	@Override
	public void setReverseRelation(Relation<To, ? extends Object, I> reverse) {
		this.reverseRelation = reverse;
	}

	@Override
	public Relation<To, ? extends Object,I> getReverseRelation() {
		return reverseRelation;
	}


	@Override
	public Entity getEntity() {
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public To createTo(I from) {
		To result = (To)getTo().createInstance(from.getCase());
		Relation<To, ? extends Object, I> reverseRelation = getReverseRelation();
		return result;
	};
	
	@Override
	public Class<To> getDatatype() {
		return valueClass;
	}
}
