package lbe.model;

import lbe.instance.Instance;
import lbe.model.pageelement.Text;

public abstract class Relation<I extends Instance, Value extends Object, To extends Instance> extends Attribute<I, Value, To> {
	
	public abstract Entity getTo();
	
	public abstract boolean isOwner();
	
	public abstract boolean isMultivalue();
	
	public abstract Relation<To, ? extends Object, I> getReverseRelation();
	
	public abstract To createTo(I from);
	
	@Override
	public Text getQuestion() {
		return null;
	}

}
