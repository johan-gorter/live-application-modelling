package lbe.model;

import lbe.instance.Instance;
import lbe.page.RenderContext;

public abstract class Relation<I extends Instance, To extends Instance> extends Attribute<I, To> {
	
	public abstract Entity getTo();
	
	public abstract boolean isOwner();
	
	public abstract boolean isMultivalue();
	
	public abstract Relation<To, I> getReverseRelation();
	
	public abstract To createTo(I from);
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<To> getDatatype() {
		return (Class<To>) Instance.class; // Cheating: the jvm does not know better
	}

	@Override
	public Text getQuestion() {
		return null;
	}

}
