package lbe.model;

import lbe.instance.Instance;
import lbe.page.RenderContext;

public abstract class RelationModel<I extends Instance, To extends Instance> extends AttributeModel<I, To> {
	
	public abstract EntityModel getTo();
	
	public abstract boolean isOwner();
	
	public abstract boolean isMultivalue();
	
	public abstract RelationModel<To, I> getReverseRelation();
	
	public abstract To createTo(I from);
	
	@Override
	public String getDatatype() {
		return DATATYPE_ENTITY;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return null;
	}

}
